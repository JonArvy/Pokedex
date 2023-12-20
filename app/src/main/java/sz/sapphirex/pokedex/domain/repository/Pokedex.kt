package sz.sapphirex.pokedex.domain.repository

import sz.sapphirex.pokedex.domain.model.DataResult
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import kotlinx.coroutines.flow.Flow

class Pokedex(
    private val repository: PokedexRepository
) {
    operator fun invoke(): Flow<DataResult<List<Pokemon>>> {
        return repository.getPokemon()
    }
}