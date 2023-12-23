package sz.sapphirex.pokedex.domain.use_case

import kotlinx.coroutines.flow.Flow
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.repository.PokemonRepository
import javax.inject.Inject

class Pokemon @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    operator fun invoke(name: String): Flow<DataResult<sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon>> {
        return pokemonRepository.getPokemon(name)
    }

    operator fun invoke(id: Int): Flow<DataResult<sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon>> {
        return pokemonRepository.getPokemon(id)
    }
}