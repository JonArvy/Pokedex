package sz.sapphirex.pokedex.data.repository

import sz.sapphirex.pokedex.data.remote.PokeApi
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.base.resource.Named
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import sz.sapphirex.pokedex.data.remote.ApiEndpoints.ENDPOINT_POKEMON
import sz.sapphirex.pokedex.data.local.PokemonDao
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonType
import sz.sapphirex.pokedex.domain.repository.PokemonListRepository
import java.io.IOException
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val pokeApi: PokeApi,
    private val dao: PokemonDao
): PokemonListRepository {
    override fun getPokemonList(): Flow<DataResult<List<Pokemon>>> = flow {
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
            } catch (e: IOException) {
                emit(DataResult.Error(e, "No Internet Connection"))
            } catch (e: Exception) {
                emit(DataResult.Error(e, e.localizedMessage))
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

    override fun searchPokemon(query: String): Flow<DataResult<List<Pokemon>>> {
        TODO("Not yet implemented")
    }

    override fun getPokemonByTypes(pokemonTypes: List<PokemonType>): Flow<DataResult<List<Pokemon>>> {
        TODO("Not yet implemented")
    }
}