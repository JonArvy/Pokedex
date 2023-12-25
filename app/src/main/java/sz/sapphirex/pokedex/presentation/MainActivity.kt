package sz.sapphirex.pokedex.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import dagger.hilt.android.AndroidEntryPoint
import sz.sapphirex.pokedex.presentation.screens.abilities.AbilityTab
import sz.sapphirex.pokedex.presentation.screens.home.HomeScreen
import sz.sapphirex.pokedex.presentation.screens.home.HomeTab
import sz.sapphirex.pokedex.presentation.screens.moves.MoveTab
import sz.sapphirex.pokedex.presentation.screens.settings.SettingsTab
import sz.sapphirex.pokedex.presentation.theme.PokedexTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val tabList = listOf(HomeTab, AbilityTab, MoveTab, SettingsTab)
                TabNavigator(tabList.first()) {
                    Scaffold(
                        content = { paddingValues ->
                            Box(modifier = Modifier.padding(paddingValues)) {
                                CurrentTab()
                            }
                        },
                        bottomBar = {
                            NavigationBar {
                                tabList.forEach { tab ->
                                    TabNavigationItem(tab = tab)
                                }
                            }
                        }
                    )
                }
//                Navigator(HomeScreen())
            }
        }
    }
}

@Composable
fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    NavigationBarItem(
        selected = tabNavigator.current == tab,
        label = { Text(text = tab.options.title) },
        onClick = { tabNavigator.current = tab },
        icon = {
            if (tab.options.icon != null) {
                Icon(
                    painter = tab.options.icon!!,
                    contentDescription = tab.options.title
                )
            }
        }
    )
}