package sz.sapphirex.pokedex.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sz.sapphirex.pokedex.domain.model.simple.pokemon.SimplePokemon
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.use_case.GetPokemonList
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getPokemonList: GetPokemonList
): ViewModel() {
    private val _pokemons = MutableStateFlow<DataResult<List<SimplePokemon>>>(DataResult.Loading)
    val pokemons = _pokemons.asStateFlow()

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        viewModelScope.launch {
            getPokemonList.invoke().collect { result ->
                _pokemons.value = result
            }
        }
    }
}