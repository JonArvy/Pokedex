package sz.sapphirex.pokedex.presentation.screens.moves

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import sz.sapphirex.pokedex.domain.model.utils.DataResult

class MoveScreen: Screen {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<MoveScreenViewModel>()
        val moves by viewModel.moves.collectAsState()
        when (val data = moves) {
            is DataResult.Loading -> {}
            is DataResult.Error -> {}
            is DataResult.Success -> {
                val pagingData = data.data
                pagingData
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
        ) {
            LazyColumn {

            }
        }
    }
}