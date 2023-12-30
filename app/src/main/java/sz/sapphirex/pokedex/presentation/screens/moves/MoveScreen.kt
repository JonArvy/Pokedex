package sz.sapphirex.pokedex.presentation.screens.moves

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel

class MoveScreen: Screen {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<MoveScreenViewModel>()
        val moves = viewModel.moves.collectAsState()
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