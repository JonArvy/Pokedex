package sz.sapphirex.pokedex.presentation.screens.moves

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import sz.sapphirex.pokedex.R

object MoveTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(id = R.string.move_tab)
            val icon = rememberVectorPainter(image = Icons.Outlined.MailOutline)

            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(MoveScreen())
    }
}