package sz.sapphirex.pokedex.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import sz.sapphirex.pokedex.data.local.PokemonDao
import sz.sapphirex.pokedex.data.remote.PokeApi
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.repository.PokemonRepository
import java.io.IOException
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokeApi: PokeApi,
    private val pokemonDao: PokemonDao
): PokemonRepository {
    override fun getPokemon(name: String): Flow<DataResult<Pokemon>> {
        TODO("Not yet implemented")
    }

    override fun getPokemon(id: Int): Flow<DataResult<Pokemon>> = flow {
        emit(DataResult.Loading)
        val cachePokemon = pokemonDao.getPokemon(id)
        if (cachePokemon == null) {
            try {
                val apiPokemon = pokeApi.getPokemon(id)
                emit(DataResult.Success(apiPokemon.toBase()))
                pokemonDao.insertPokemon(apiPokemon.toBase().toEntity())
            } catch (e: IOException) {
                emit(DataResult.Error(e, "No Internet Connection"))
            } catch (e: Exception) {
                emit(DataResult.Error(e, e.message.toString()))
            }
        } else {
            emit(DataResult.Success(cachePokemon.toBase()))
        }
    }
}