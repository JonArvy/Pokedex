package sz.sapphirex.pokedex.data.repository

import android.util.Log
import sz.sapphirex.pokedex.data.remote.PokeApi
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.data.local.entity.resource.NamedEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import sz.sapphirex.pokedex.data.remote.ApiEndpoints.ENDPOINT_POKEMON
import sz.sapphirex.pokedex.data.local.PokemonDao
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonEntity
import sz.sapphirex.pokedex.data.remote.dto.pokemon.PokemonDto
import sz.sapphirex.pokedex.data.remote.dto.resource.NamedDto
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonType
import sz.sapphirex.pokedex.domain.model.base.resource.Named
import sz.sapphirex.pokedex.domain.model.simple.pokemon.toSimple
import sz.sapphirex.pokedex.domain.repository.PokemonListRepository
import java.io.IOException
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val pokeApi: PokeApi,
    private val dao: PokemonDao
): PokemonListRepository {

    override fun getPokemonList(): Flow<DataResult<List<Pokemon>>> = flow {
        emit(DataResult.Loading)

        try {
            val firstPageDao: NamedEntity? = dao.getNamed(ENDPOINT_POKEMON)

            if (firstPageDao != null) {
                val firstPagePokemons: List<String> = firstPageDao.results.map { it.name }
                emit(DataResult.Success(dao.getPokemonListByName(firstPagePokemons).map { it.toBase() }))
            } else {
                handleApiCall()
            }
        } catch (e: IOException) {
            handleOfflineError()
        } catch (e: Exception) {
            handleGenericError(e)
        }
    }

    private suspend fun FlowCollector<DataResult<List<Pokemon>>>.handleApiCall() {
        try {
            val firstPageApi: NamedDto = pokeApi.getDataByEndpoint(ENDPOINT_POKEMON)
            val pokemonList: List<Pokemon> = firstPageApi.results.map { result ->
                val daoPokemon: PokemonEntity? = dao.getPokemon(result.name)
                if (daoPokemon == null) {
                    val pokemon: PokemonDto = pokeApi.getPokemon(result.name)
                    pokemon.toBase()
                } else {
                    daoPokemon.toBase()
                }
            }
            emit(DataResult.Success(pokemonList))
            dao.insertNamed(firstPageApi.toEntity(ENDPOINT_POKEMON))
            pokemonList.forEach { dao.insertPokemon(it.toEntity()) }
        } catch (e: IOException) {
            handleOfflineError()
        } catch (e: Exception) {
            handleGenericError(e)
        }
    }

    private suspend fun FlowCollector<DataResult<List<Pokemon>>>.handleOfflineError() {
        val offLinePage: NamedEntity? = dao.getNamed(ENDPOINT_POKEMON)
        if (offLinePage != null) {
            val firstPagePokemons: List<String> = offLinePage.results.map { it.name }
            emit(DataResult.Success(dao.getPokemonListByName(firstPagePokemons).map { it.toBase() }))
        } else {
            emit(DataResult.Error(IOException("No Internet Connection"), "No Internet Connection"))
        }
    }

    private suspend fun FlowCollector<DataResult<List<Pokemon>>>.handleGenericError(e: Exception) {
        Log.e("Err", "${e.message}")
        emit(DataResult.Error(e, e.localizedMessage))
    }

    override fun searchPokemon(query: String): Flow<DataResult<List<Pokemon>>> {
        TODO("Not yet implemented")
    }

    override fun getPokemonByTypes(pokemonTypes: List<PokemonType>): Flow<DataResult<List<Pokemon>>> {
        TODO("Not yet implemented")
    }
}