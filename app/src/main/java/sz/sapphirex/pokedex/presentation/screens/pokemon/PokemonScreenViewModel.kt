package sz.sapphirex.pokedex.presentation.screens.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.use_case.GetPokemon
import javax.inject.Inject

@HiltViewModel
class PokemonScreenViewModel @Inject constructor(
    private val getPokemon: GetPokemon
): ViewModel() {
    private val _pokemon = MutableStateFlow<DataResult<Pokemon>>(DataResult.Loading)
    val pokemon = _pokemon.asStateFlow()

    fun getPokemon(id: Int) {
        viewModelScope.launch {
            getPokemon.invoke(id).collect { result ->
                _pokemon.value = result
            }
        }
    }
}