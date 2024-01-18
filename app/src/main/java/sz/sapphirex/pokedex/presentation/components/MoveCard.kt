package sz.sapphirex.pokedex.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import sz.sapphirex.pokedex.domain.model.simple.moves.SimpleMove
import sz.sapphirex.pokedex.presentation.utils.toColor
import sz.sapphirex.pokedex.presentation.utils.toMoveNameCase

@Composable
fun MoveCard(
    move: SimpleMove
) {
    Surface(
        color = move.type?.toColor() ?: Color.Unspecified
    ) {
        Text(text = move.name.toMoveNameCase(), modifier = Modifier.padding(16.dp))
    }
}