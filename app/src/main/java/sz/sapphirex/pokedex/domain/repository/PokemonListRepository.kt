package sz.sapphirex.pokedex.domain.repository

import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import kotlinx.coroutines.flow.Flow
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonType

interface PokemonListRepository {
    fun getPokemonList(): Flow<DataResult<List<Pokemon>>>

    fun searchPokemon(query: String): Flow<DataResult<List<Pokemon>>>

    fun getPokemonByTypes(pokemonTypes: List<PokemonType>): Flow<DataResult<List<Pokemon>>>


}