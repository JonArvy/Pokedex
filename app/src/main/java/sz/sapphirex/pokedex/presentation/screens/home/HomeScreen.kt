package sz.sapphirex.pokedex.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import coil.compose.AsyncImage
import sz.sapphirex.pokedex.domain.model.simple.pokemon.SimplePokemon
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.presentation.components.PokemonCard
import sz.sapphirex.pokedex.presentation.utils.toColor
import sz.sapphirex.pokedex.presentation.utils.toNameCase

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