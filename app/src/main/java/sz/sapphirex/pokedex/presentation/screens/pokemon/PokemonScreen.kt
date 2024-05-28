package sz.sapphirex.pokedex.presentation.screens.pokemon

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import coil.compose.AsyncImage
import sz.sapphirex.pokedex.R
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.simple.pokemon.SimplePokemon
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.presentation.utils.toColor
import sz.sapphirex.pokedex.presentation.utils.toNameCase

data class PokemonScreen(
    private val simplePokemon: SimplePokemon
): Screen {
    @Composable
    override fun Content() {
        val pokemonScreenViewModel = getViewModel<PokemonScreenViewModel>()
        val pokemonResult by pokemonScreenViewModel.pokemon.collectAsState()

        LaunchedEffect(Unit) {
            pokemonScreenViewModel.getPokemon(simplePokemon.id) // Invoke part
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            when (val data = pokemonResult) {
                is DataResult.Success -> PokemonPage(pokemon = data.data)
                is DataResult.Error -> Text(text = data.message)
                is DataResult.Loading -> PokemonPage(simplePokemon = simplePokemon)
            }
        }
    }

    @Composable
    fun PokemonPage(simplePokemon: SimplePokemon) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.3f),
            color = simplePokemon.types.toColor()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PokemonPageTopBar(
                    pokemonName = simplePokemon.name,
                    pokemonId = simplePokemon.id
                )
                AsyncImage(
                    model = simplePokemon.sprites.frontDefault,
                    contentDescription = simplePokemon.name,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxSize()
                )
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
                PokemonPageTopBar(
                    pokemonName = pokemon.name,
                    pokemonId = pokemon.id
                )
                AsyncImage(
                    model = pokemon.sprites.frontDefault,
                    contentDescription = pokemon.name,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

    @Composable
    fun PokemonPageTopBar(pokemonName: String, pokemonId: Int) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = { /*TODO*/ },
                content = {
                    Image(painter = painterResource(id = R.drawable.arrow_back), contentDescription = null, modifier = Modifier.size(16.dp))
                }
            )
            Text(text = pokemonName.toNameCase(), fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Text(text = "#$pokemonId", fontWeight = FontWeight.Bold, fontSize = 12.sp)
        }
    }
}