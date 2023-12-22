package sz.sapphirex.pokedex.data.repository

import kotlinx.coroutines.flow.Flow
import sz.sapphirex.pokedex.data.local.PokemonDao
import sz.sapphirex.pokedex.data.remote.PokeApi
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokeApi: PokeApi,
    private val pokemonDao: PokemonDao
): PokemonRepository {
    override fun getPokemon(name: String): Flow<DataResult<Pokemon>> {
        TODO("Not yet implemented")
    }

    override fun getPokemon(id: Int): Flow<DataResult<Pokemon>> {
        TODO("Not yet implemented")
    }
}