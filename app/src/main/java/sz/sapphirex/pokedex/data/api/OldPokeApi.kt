package sz.sapphirex.pokedex.data.api

import android.content.Context
import android.util.Log
import androidx.room.Room
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import sz.sapphirex.pokedex.data.room.PokemonDao
import sz.sapphirex.pokedex.data.room.PokemonDatabase
import sz.sapphirex.pokedex.domain.model.ApiResult
import sz.sapphirex.pokedex.domain.model.base.pokemon.abilities.Ability
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.base.pokemon.pokemonspecies.PokemonSpecies
import sz.sapphirex.pokedex.domain.model.base.resource.Named

class OldPokeApi(context: Context) {
    private val database: PokemonDatabase = Room.databaseBuilder(context, PokemonDatabase::class.java, "app_database").build()
    private val pokemonDao: PokemonDao = database.pokemonDao()

    private val defaultRequestApi = "https://pokeapi.co/api/v2/"
    private val client = HttpClient(OkHttp) {
        install(HttpCache)
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    /******************** GENERAL REQUEST ********************/
    suspend fun prefixedRequest(prefix: String): ApiResult<Named> {
//        val localNamed = pokemonDao.getNamed(prefix)
//        if (localNamed != null) {
//            return ApiResult.Success(localNamed)
//        }

        val response = try {
            val result = client.get(prefix)
            val named: Named = result.body()
//            named.id = prefix
//            pokemonDao.insertNamed(named)
            ApiResult.Success(named)
        } catch (e: Exception) {
            ApiResult.Error(e)
        }

        return response
    }


    /******************** LISTS ********************/
    suspend fun getPokemonList(): ApiResult<Named> {
        val httpRequestLink = "${defaultRequestApi}pokemon/"
//        val localNamed = pokemonDao.getNamed(httpRequestLink)
//        if (localNamed != null) {
//            return ApiResult.Success(localNamed)
//        }

        val response = try {
            val result = client.get(httpRequestLink)
            val named: Named = result.body()
//            named.id = httpRequestLink
//            pokemonDao.insertNamed(named)
            ApiResult.Success(named)
        } catch (e: Exception) {
            ApiResult.Error(e)
        }
        return response
    }

    suspend fun getEveryPokemonInList(named: Named): ApiResult<List<Pokemon>> {
        val response = try {
            val pokeList = named.results.map { pokemon ->
                when (val result = getPokemon(pokemon.name)) {
                    is ApiResult.Success -> result.data
                    is ApiResult.Error -> return ApiResult.Error(result.exception)
                    is ApiResult.Loading -> return ApiResult.Loading
                }
            }
            ApiResult.Success(pokeList)
        } catch (e: Exception) {
            ApiResult.Error(e)
        }
        return response
    }

    /******************** POKEMON SPECIES ********************/
    suspend fun getPokemonSpecies(id: Int): ApiResult<PokemonSpecies> {
        val response = try {
            val result = client.get("${defaultRequestApi}pokemon-species/$id/")
            ApiResult.Success(result.body() as PokemonSpecies)
        } catch (e: Exception) {
            apiLogger(e.message)
            ApiResult.Error(e)
        }
        return response
    }

    suspend fun getPokemonSpecies(name: String): ApiResult<PokemonSpecies> {
        val response = try {
            val result = client.get("${defaultRequestApi}pokemon-species/$name/")
            ApiResult.Success(result.body() as PokemonSpecies)
        } catch (e: Exception) {
            apiLogger(e.message)
            ApiResult.Error(e)
        }
        return response
    }

    /******************** POKEMON ********************/
    suspend fun getPokemon(id: Int): ApiResult<Pokemon> {
        val response = try {
            val result = client.get("${defaultRequestApi}pokemon/$id/")
            ApiResult.Success(result.body() as Pokemon)
        } catch (e: Exception) {
            apiLogger(e.message)
            ApiResult.Error(e)
        }
        return response
    }

    suspend fun getPokemon(name: String): ApiResult<Pokemon> {
//        val localPokemon = pokemonDao.getPokemon(name)
//        if (localPokemon != null) {
//            return ApiResult.Success(localPokemon)
//        }

        val response = try {
            val result = client.get("${defaultRequestApi}pokemon/$name/")
            val pokemon: Pokemon = result.body()
//            pokemonDao.insertPokemon(pokemon)
            ApiResult.Success(pokemon)
        } catch (e: Exception) {
            apiLogger(e.message)
            ApiResult.Error(e)
        }
        return response
    }

    suspend fun getPokemonAbility(id: Int): ApiResult<Ability> {
        val response = try {
            val result = client.get("${defaultRequestApi}ability/$id/")
            ApiResult.Success(result.body() as Ability)
        } catch (e: Exception) {
            apiLogger(e.message)
            ApiResult.Error(e)
        }
        return response
    }

    suspend fun getPokemonAbility(name: String): ApiResult<Ability> {
        val response = try {
            val result = client.get("${defaultRequestApi}ability/$name/")
            ApiResult.Success(result.body() as Ability)
        } catch (e: Exception) {
            apiLogger(e.message)
            ApiResult.Error(e)
        }
        return response
    }

    /******************** LOGGER ********************/
    private fun apiLogger(
        message: String?,
        type: Int = 0,
    ) {
        if (message != null) {
            when (type) {
                0 -> Log.e("PokeApiError", message)
                1 -> Log.i("PokeApiError", message)
                2 -> Log.d("PokeApiError", message)
                3 -> Log.v("PokeApiError", message)
                4 -> Log.w("PokeApiError", message)
                5 -> Log.wtf("PokeApiError", message)
            }
        } else {
            Log.e("PokeApiError", "Message doesn't exist")
        }
    }
}