package sz.sapphirex.pokedex.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import sz.sapphirex.pokedex.core.logger.Logger
import sz.sapphirex.pokedex.data.local.PokemonDao
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonEntity
import sz.sapphirex.pokedex.data.local.entity.resource.NamedEntity
import sz.sapphirex.pokedex.data.remote.ApiEndpoints.ENDPOINT_POKEMON
import sz.sapphirex.pokedex.data.remote.PokeApi
import sz.sapphirex.pokedex.data.remote.dto.pokemon.PokemonDto
import sz.sapphirex.pokedex.data.remote.dto.resource.NamedDto
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonType
import sz.sapphirex.pokedex.domain.model.simple.pokemon.SimplePokemon
import sz.sapphirex.pokedex.domain.model.simple.pokemon.toSimple
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.repository.PokemonListRepository
import sz.sapphirex.pokedex.presentation.utils.toNameCase
import java.io.IOException
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val pokeApi: PokeApi,
    private val dao: PokemonDao,
    private val logger: Logger
): PokemonListRepository {

    override fun getPokemonList(): Flow<DataResult<List<SimplePokemon>>> = flow {
        emit(DataResult.Loading)

        try {
            val firstPageDao: NamedEntity? = dao.getNamed(ENDPOINT_POKEMON)
            if (firstPageDao != null) {
                logger.database("Get Named", "Successfully get named with id of: $ENDPOINT_POKEMON")

                val firstPagePokemons: List<String> = firstPageDao.results.map { it.name }
                logger.database("Get Pokemons", "getPokemonListByName list with names of: $firstPagePokemons")

                emit(DataResult.Success(dao.getPokemonListByName(firstPagePokemons).map {
                    logger.database("Get Pokemon", "getPokemonListByName individually with name of: ${it.name.toNameCase()}", true)
                    it.toBase().toSimple()
                }))

            } else {
                handleApiCall()
            }
        } catch (e: IOException) {
            handleOfflineError()
        } catch (e: Exception) {
            handleGenericError(e)
        }
    }

    private suspend fun FlowCollector<DataResult<List<SimplePokemon>>>.handleApiCall() {
        try {
            val firstPageApi: NamedDto = pokeApi.getDataByEndpoint(ENDPOINT_POKEMON)
            logger.database("Get Named", "Successfully get named with id of: $ENDPOINT_POKEMON")
            val pokemonList: List<Pokemon> = firstPageApi.results.map { result ->

                val daoPokemon: PokemonEntity? = dao.getPokemon(result.name)

                if (daoPokemon == null) {
                    val pokemon: PokemonDto = pokeApi.getPokemon(result.name)

                    logger.api("Get Pokemon", "Successfully get pokemon with name of: ${result.name.toNameCase()}", true)
                    pokemon.toBase()
                } else {
                    logger.database("Get Pokemon", "Successfully get pokemon with name of: ${result.name.toNameCase()}", true)
                    daoPokemon.toBase()
                }
            }
            val namedEntity = firstPageApi.toEntity(ENDPOINT_POKEMON)

            emit(DataResult.Success(pokemonList.map { it.toSimple() }))
            dao.insertNamed(namedEntity)
            logger.database("Inserting Named", "Successfully inserted Named with id of: $ENDPOINT_POKEMON")

            pokemonList.forEach { dao.insertPokemon(it.toEntity()) }
            logger.database("Inserted Pokemon", "Successfully inserted list of pokemons with names of: ${pokemonList.map { it.name }}")

        } catch (e: IOException) {
            handleOfflineError()
        } catch (e: Exception) {
            handleGenericError(e)
        }
    }

    private suspend fun FlowCollector<DataResult<List<SimplePokemon>>>.handleOfflineError() {
        val offLinePage: NamedEntity? = dao.getNamed(ENDPOINT_POKEMON)
        if (offLinePage != null) {
            logger.database("Get Named", "Successfully get named with id of: $ENDPOINT_POKEMON")

            val firstPagePokemons: List<String> = offLinePage.results.map { it.name }
            val data = dao.getPokemonListByName(firstPagePokemons).map {it.toBase().toSimple()}
            emit(DataResult.Success(data))
            logger.database("Get Pokemons", "Successfully get pokemons list with names: ${data.map { it.name }}")
        } else {
            emit(DataResult.Error(IOException("No Internet Connection"), "No Internet Connection"))
        }
    }

    private suspend fun FlowCollector<DataResult<List<SimplePokemon>>>.handleGenericError(e: Exception) {
        logger.generic("Handle Generic Error", e.message.toString())
        emit(DataResult.Error(e, e.message.toString()))
    }

    override fun searchPokemon(query: String): Flow<DataResult<List<Pokemon>>> {
        TODO("Not yet implemented")
    }

    override fun getPokemonByTypes(pokemonTypes: List<PokemonType>): Flow<DataResult<List<Pokemon>>> {
        TODO("Not yet implemented")
    }
}