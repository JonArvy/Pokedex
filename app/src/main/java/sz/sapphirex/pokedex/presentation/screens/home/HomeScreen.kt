package sz.sapphirex.pokedex.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import sz.sapphirex.pokedex.domain.model.simple.moves.SimpleMove
import sz.sapphirex.pokedex.domain.model.simple.pokemon.SimplePokemon
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.presentation.components.PokemonCard

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val homeScreenViewModel = getViewModel<HomeScreenViewModel>()
        val pokemonData = homeScreenViewModel.pagedData.collectAsLazyPagingItems()

        Column(modifier = Modifier.fillMaxSize()) {
            val lazyState = rememberLazyGridState()
            LazyVerticalGrid(
                state = lazyState,
                columns = GridCells.Fixed(count = 2),
                contentPadding = PaddingValues(4.dp),
            ) {
                items(
                    count = pokemonData.itemCount,
                    key = pokemonData.itemKey { data -> data.id },
                    contentType = pokemonData.itemContentType { "Pokemons" },
                ) {index ->
                    val pokemon: SimplePokemon? = pokemonData[index]

                    pokemon?.let {
                        PokemonCard(pokemon = it, padding = PaddingValues(4.dp))
                    }
                }
                if (pokemonData.loadState.append == LoadState.Loading) item { CircularProgressIndicator() }
            }
        }
    }
}