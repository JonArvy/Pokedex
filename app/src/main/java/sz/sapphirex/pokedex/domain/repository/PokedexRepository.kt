package sz.sapphirex.pokedex.domain.repository

import sz.sapphirex.pokedex.domain.model.DataResult
import sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {
    fun getPokemon(): Flow<DataResult<List<Pokemon>>>
}