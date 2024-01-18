package sz.sapphirex.pokedex.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sz.sapphirex.pokedex.domain.model.simple.moves.SimpleMove
import sz.sapphirex.pokedex.domain.model.simple.pokemon.SimplePokemon
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.use_case.GetPokemonList
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getPokemonList: GetPokemonList
): ViewModel() {
//    private val _pokemons = MutableStateFlow<DataResult<List<SimplePokemon>>>(DataResult.Loading)
    private val _pokemons = MutableStateFlow<DataResult<PagingData<SimplePokemon>>>(DataResult.Loading)
    val pokemons = _pokemons.asStateFlow()

    val pagedData: Flow<PagingData<SimplePokemon>> = getPokemonList.invoke().cachedIn(viewModelScope)

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        viewModelScope.launch {
            getPokemonList.invoke().collect { result ->
                _pokemons.value = DataResult.Success(result)
            }
        }
    }
}