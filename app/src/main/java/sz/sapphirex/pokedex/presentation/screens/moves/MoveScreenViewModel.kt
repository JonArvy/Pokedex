package sz.sapphirex.pokedex.presentation.screens.moves

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sz.sapphirex.pokedex.domain.model.simple.moves.SimpleMove
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.use_case.GetMoveList
import javax.inject.Inject

@HiltViewModel
class MoveScreenViewModel @Inject constructor(
    private val getMoveList: GetMoveList
): ViewModel()  {
    private val _moves = MutableStateFlow<DataResult<PagingData<SimpleMove>>>(DataResult.Loading)
    val moves = _moves.asStateFlow()

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        viewModelScope.launch {
            getMoveList.invoke().collect { result ->
                _moves.value = DataResult.Success(result)
            }
        }
    }
}