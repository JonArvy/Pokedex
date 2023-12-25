package sz.sapphirex.pokedex.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.presentation.components.PokemonCard

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val homeScreenViewModel = getViewModel<HomeScreenViewModel>()
        val pokemons by homeScreenViewModel.pokemons.collectAsState()
        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                when (val data = pokemons) {
                    is DataResult.Success -> {
                        val lazyState = rememberLazyGridState()
                        LazyVerticalGrid(
                            state = lazyState,
                            columns = GridCells.Fixed(count = 2),
                            contentPadding = PaddingValues(4.dp),
                        ) {
                            data.data.forEach {
                                item {
                                    PokemonCard(pokemon = it, padding = PaddingValues(4.dp))
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