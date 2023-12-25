package sz.sapphirex.pokedex.presentation.screens.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import coil.compose.AsyncImage
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.presentation.utils.toColor

data class PokemonScreen(
    private val id: Int
): Screen {
    @Composable
    override fun Content() {
        val pokemonScreenViewModel = getViewModel<PokemonScreenViewModel>()
        val pokemonResult by pokemonScreenViewModel.pokemon.collectAsState()

        pokemonScreenViewModel.getPokemon(id) // Invoke part

        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            when (val data = pokemonResult) {
                is DataResult.Success -> PokemonPage(pokemon = data.data)
                is DataResult.Error -> Text(text = data.message)
                is DataResult.Loading -> Text(text = "Loading")
            }
        }
    }

    @Composable
    fun PokemonPage(pokemon: Pokemon) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.3f),
            color = pokemon.types.toColor()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = pokemon.sprites.frontDefault,
                    contentDescription = pokemon.name,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}