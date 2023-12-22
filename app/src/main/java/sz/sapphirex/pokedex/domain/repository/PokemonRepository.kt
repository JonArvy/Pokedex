package sz.sapphirex.pokedex.domain.repository

import kotlinx.coroutines.flow.Flow
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.utils.DataResult

interface PokemonRepository {
    fun getPokemon(name: String): Flow<DataResult<Pokemon>>

    fun getPokemon(id: Int): Flow<DataResult<Pokemon>>
}