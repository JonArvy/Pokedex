package sz.sapphirex.pokedex.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import sz.sapphirex.pokedex.domain.model.utils.DataResult

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val homeScreenViewModel = getViewModel<HomeScreenViewModel>()
        val pokemons by homeScreenViewModel.pokemons.collectAsState()
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                when (val data = pokemons) {
                    is DataResult.Success -> {
                        LazyColumn {
                            data.data.forEach {
                                item {
                                    Text(text = it.name)
                                }
                            }
                        }
                    }
                    is DataResult.Error -> Text(text = data.message)
                    is DataResult.Loading -> Text(text = "Loading")
                }
            }
        }
    }
}