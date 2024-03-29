package sz.sapphirex.pokedex.domain.use_case

import android.webkit.WebViewClient
import androidx.paging.PagingData
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import kotlinx.coroutines.flow.Flow
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonType
import sz.sapphirex.pokedex.domain.model.simple.pokemon.SimplePokemon
import sz.sapphirex.pokedex.domain.repository.PokemonListRepository
import javax.inject.Inject

class GetPokemonList @Inject constructor(
    private val repository: PokemonListRepository
) {
    operator fun invoke(): Flow<PagingData<SimplePokemon>> {
        return repository.getPokemonPagingData()
    }

    operator fun invoke(query: String): Flow<DataResult<List<Pokemon>>> {
        return repository.searchPokemon(query)
    }

    operator fun invoke(pokemonTypes: List<PokemonType>): Flow<DataResult<List<Pokemon>>> {
        return repository.getPokemonByTypes(pokemonTypes)
    }
}