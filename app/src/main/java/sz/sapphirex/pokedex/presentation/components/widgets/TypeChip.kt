package sz.sapphirex.pokedex.presentation.components.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TypeChip(
    modifier: Modifier = Modifier,
    shape: Shape = TypeChipShape,
    minHeight: Dp = TypeChipMinHeight,
    paddingValues: PaddingValues = TypeChipPadding,
    elevation: Dp? = TypeChipElevation,
    border: BorderStroke? = TypeChipBorder.defaultBorder(),
    color: Color = TypeChipColor,
    label: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier,
        shape = shape,
        tonalElevation = elevation ?: 0.dp,
        shadowElevation = elevation ?: 0.dp,
        border = border,
        color = color
    ) {
        TypeChipContent(
            labelTextStyle = MaterialTheme.typography.labelLarge,
            labelColor = MaterialTheme.colorScheme.onSurface,
            minHeight = minHeight,
            paddingValues = paddingValues,
            label = label,
        )
    }
}

@Composable
fun TypeChipContent(
    labelTextStyle: TextStyle,
    labelColor: Color,
    minHeight: Dp,
    paddingValues: PaddingValues,
    label: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalTextStyle provides labelTextStyle,
        LocalContentColor provides labelColor,
    ) {
        Row(
            Modifier
                .defaultMinSize(minHeight = minHeight)
                .padding(paddingValues),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.width(HorizontalElementsPadding))
            label()
            Spacer(Modifier.width(HorizontalElementsPadding))
        }
    }
}

private val HorizontalElementsPadding = 8.dp

private val TypeChipPadding = PaddingValues(horizontal = HorizontalElementsPadding)

private val TypeChipMinHeight = 32.0.dp

private val TypeChipShape = RoundedCornerShape(16.dp)

private val TypeChipColor = Color.Transparent

//private val TypeChipBorder = BorderStroke(1.dp, Color.Black)

private val TypeChipElevation = 0.dp

object TypeChipBorder {
    fun borderless() = null
    fun defaultBorder() = BorderStroke(1.dp, Color.Black)
    fun customBorder(border: BorderStroke) = border
}