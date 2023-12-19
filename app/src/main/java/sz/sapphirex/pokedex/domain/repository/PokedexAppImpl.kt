package sz.sapphirex.pokedex.domain.repository

import kek.dex.pokedex.data.api.RawPokeApi
import sz.sapphirex.pokedex.domain.model.DataResult
import sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.base.resource.Named
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import sz.sapphirex.pokedex.data.api.ApiEndpoints.ENDPOINT_POKEMON
import sz.sapphirex.pokedex.data.room.PokemonDao

class PokedexAppImpl(
    private val pokeApi: RawPokeApi,
    private val dao: PokemonDao
): PokedexRepository {
    override fun getPokemon(): Flow<DataResult<List<Pokemon>>> = flow {
        emit(DataResult.Loading)

        // Emit first 20 items from db,
        val firstPageDao: Named? = dao.getNamed(ENDPOINT_POKEMON)
        if (firstPageDao != null) {
            val firstPagePokemons: List<String> = firstPageDao.results.map { it.name }
            emit(DataResult.Success(dao.getPokemonListByName(firstPagePokemons)))
        } else {
            try {
                val firstPageApi: Named = pokeApi.getDataByEndpoint(ENDPOINT_POKEMON)
                dao.insertNamed(firstPageApi)
                val data: List<Pokemon> = firstPageApi.results.map { result ->
                    val daoPokemon = dao.getPokemon(result.name)
                    if (daoPokemon == null) {
                        val pokemon = pokeApi.getPokemon(result.name)
                        dao.insertPokemon(pokemon)
                        pokemon
                    } else {
                        daoPokemon
                    }
                }
                emit(DataResult.Success(data))
            } catch (e: Exception) {
                emit(DataResult.Error(e))
            }
        }

        //Emit all other items
//        val daoPokemonList = dao.getAllPokemon()
//        if (daoPokemonList.isEmpty()) {
//            emit(DataResult.Loading)
//        } else {
//            emit(DataResult.Success(daoPokemonList))
//        }
    }
}