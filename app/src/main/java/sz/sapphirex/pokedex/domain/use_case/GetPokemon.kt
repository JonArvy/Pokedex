package sz.sapphirex.pokedex.domain.use_case

import kotlinx.coroutines.flow.Flow
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemon @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    operator fun invoke(name: String): Flow<DataResult<Pokemon>> {
        return pokemonRepository.getPokemon(name)
    }

    operator fun invoke(id: Int): Flow<DataResult<Pokemon>> {
        return pokemonRepository.getPokemon(id)
    }
}