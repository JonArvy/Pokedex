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
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import sz.sapphirex.pokedex.domain.model.simple.moves.SimpleMove
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.presentation.components.MoveCard

class MoveScreen: Screen {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<MoveScreenViewModel>()
        val moveData = viewModel.pagedData.collectAsLazyPagingItems()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
        ) {
            LazyColumn {
                items(
                    count = moveData.itemCount,
                    key = moveData.itemKey { moveData -> moveData.id },
                    contentType = moveData.itemContentType { "Moves" },
                ) {index ->
                    val move: SimpleMove? = moveData[index]

                    move?.let {
//                        Text(text = it.name)
                        MoveCard(move = it)
                    }
                }
            }
        }
    }
}