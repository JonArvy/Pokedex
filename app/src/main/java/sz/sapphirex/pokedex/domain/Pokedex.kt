package sz.sapphirex.pokedex.domain

import android.content.Context
import androidx.room.Room
import sz.sapphirex.pokedex.data.api.ApiEndpoints.ENDPOINT_POKEMON
import sz.sapphirex.pokedex.data.api.PokeApi
import sz.sapphirex.pokedex.data.room.PokemonDao
import sz.sapphirex.pokedex.data.room.PokemonDatabase
import sz.sapphirex.pokedex.domain.model.ApiResult
import sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.base.resource.Named
import sz.sapphirex.pokedex.domain.utils.hasInternetConnection

@Deprecated("Migration with flow usage in PokedexRepository")
class Pokedex(private val context: Context) {
    private val pokeApi = PokeApi()

    private val database: PokemonDatabase = Room.databaseBuilder(context, PokemonDatabase::class.java, "app_database").build()
    private val pokemonDao: PokemonDao = database.pokemonDao()

    private var currentLoadedPage: String = ""
    /**
     * By endpoint call
     * Save cache page data and all items(pokemon)
     * */

    @Deprecated("Migration with flow usage in PokedexRepository")
    suspend fun loadPageItems(
        endpoint: String = ENDPOINT_POKEMON
    ): ApiResult<List<Pokemon>> {
        return when (val result = checkNamedThenCache(endpoint)) {
            is ApiResult.Success -> {
                val pokemonResults = result.data.results.map { checkPokemonThenCache(it.name) }
                val successfulPokemon = mutableListOf<Pokemon>()
                for (pokemonResult in pokemonResults) {
                    pokemonResult.getSuccessResult<Pokemon>()?.let { successfulPokemon.add(it) }
                }
                ApiResult.Success(successfulPokemon.toList())
            }
            is ApiResult.Error -> {
                ApiResult.Error(result.exception)
            }
            is ApiResult.Loading -> {
                ApiResult.Loading
            }
        }
    }

    /**
     * Check Named model: Named, page model
     * Collect from room then if it doesn't exist, load from api then
     * save it on room
     * */
    @Deprecated("Migration with flow usage in PokedexRepository")
    private suspend fun checkNamedThenCache(url: String): ApiResult<Named> {
        val named = pokemonDao.getNamed(url)
        return if (named == null) {
            val apiNamed = pokeApi.getDataByEndpoint(url)
            apiNamed.getSuccessResult<Named>()?.let {
                pokemonDao.insertNamed(it.copy(id = url))
            }
            apiNamed
        } else {
            ApiResult.Success(named)
        }
    }

    /**
     * Check Pokemon model: Pokemon, data model
     * Collect from room then if it doesn't exist, load from api then
     * save it on room
     * */
    @Deprecated("Migration with flow usage in PokedexRepository")
    private suspend fun checkPokemonThenCache(name: String): ApiResult<Pokemon> {
        val pokemon = pokemonDao.getPokemon(name)
        return if (pokemon == null) {
            val apiPokemon = pokeApi.getPokemon(name)
            apiPokemon.getSuccessResult<Pokemon>()?.let { pokemonDao.insertPokemon(it) }
            apiPokemon
        } else {
            ApiResult.Success(pokemon)
        }
    }

    /**
     * Todo: Should it return pair? Pair<List<Pokemon>>, String(endpoint)>?
     * So i can return which specific endpoint and continue loading from that endpoint?
     * */
    @Deprecated("Migration with flow usage in PokedexRepository")
    private suspend fun checkUpUntilCached(
        endpoint: String = ENDPOINT_POKEMON,
        accumulator: List<Pokemon> = emptyList()
    ): Pair<List<Pokemon>, String> {
        val named = pokemonDao.getNamed(endpoint)
        return if (named != null) {
            val updatedList = accumulator.toMutableList()
            for (result in named.results) {
                val pokemon = pokemonDao.getPokemon(result.name)
                if (pokemon != null) {
                    updatedList.add(pokemon)
                }
            }
            named.next?.let { checkUpUntilCached(it, updatedList) } ?: Pair(updatedList.toList(), endpoint)
        } else {
            Pair(accumulator.toList(), endpoint)
        }
    }

    // Main Function
    @Deprecated("Migration with flow usage in PokedexRepository")
    suspend fun initialPokedexLoad(
        endpoint: String = ENDPOINT_POKEMON
    ): ApiResult<List<Pokemon>> {
        return if (context.hasInternetConnection()) {
            loadPokedex(endpoint)
        } else {
            ApiResult.Success(checkUpUntilCached().first)
        }
    }

    @Deprecated("Migration with flow usage in PokedexRepository")
    private suspend fun loadPokedex(endpoint: String): ApiResult<List<Pokemon>> {
        val cachedPageFromRoom = pokemonDao.getNamed(endpoint)
        return if (cachedPageFromRoom != null) { // Case if this isn't the first time the app has been ran
            val lastCachedData = checkUpUntilCached(endpoint) // Return all cached data in room wherein first is list of pokemon and 2nd is last page
            /*** Will change this after transaction implementation in room ***/
            lastCachedData.first // List of pokemon
            currentLoadedPage = lastCachedData.second
            val resultFromEndpoint = loadPageItems(lastCachedData.second).getSuccessResult<List<Pokemon>>() // new list of pokemon
            val combinedList: List<Pokemon> = resultFromEndpoint?.let { newData -> lastCachedData.first + newData.filter { !lastCachedData.first.contains(it) } } ?: emptyList()

            ApiResult.Success(combinedList) // List of all cached pokemons and up until to its last loaded page
        } else {
            loadPageItems() // One time call for first time the system is called
        }
    }

    @Deprecated("Migration with flow usage in PokedexRepository")
    suspend fun appendNextPage(previousResult: ApiResult<List<Pokemon>>): ApiResult<List<Pokemon>> {
        val newList = mutableListOf<Pokemon>()
        previousResult.getSuccessResult<List<Pokemon>>()?.let { newList.addAll(it) }
        loadPageItems(currentLoadedPage).getSuccessResult<List<Pokemon>>()?.let { newList.addAll(it) }
        return ApiResult.Success(newList.toList())
    }

    /**
     * Todo: room transaction for page for breaking when either breaks
     * */

    /**
    Load initial paging data -> Named from ROOM
        then load all items for all of it -> Pokemon FROM ROOM
            if not all data is loaded, load the missing data ->
                IF HAS INTERNET Pokemon FROM API Then save to ROOM AND FILL UP UNTIL CURRENT PAGE
                ELSE BREAK ALL OPERATIONS AND ONLY SHOW AVAILABLE DATA
    */


    /**
     Behaviors:
     Has Internet:
        Initial load -> No data in room and api call all
        First page only call -> First page only stored in room
        First page incomplete -> First page incomplete room data
        Has multiple pages saved in room -> load all available up until that page and wait for user to interact(scroll) to load more


     No Internet:
        Load only available data -> From room

     Has Internet but changed to no internet:
        Stop api calls -> Pause or end jobs?

     Has no internet but changed to has internet:
        Trigger restart api call -> resume or retry suspend functions?
     */

    /**
     * New Behaviors:
     * Collect all data from room database in bulk
     * Compare named list to item which exist then call missing api from the last current list // Will change after transaction implementation
     *
     * */


    suspend fun trainingGrounds(): ApiResult<List<Pokemon>> {
        return pokemonDao.getAllPokemon()?.let { ApiResult.Success(it) } ?: ApiResult.Success(emptyList())
    }
}