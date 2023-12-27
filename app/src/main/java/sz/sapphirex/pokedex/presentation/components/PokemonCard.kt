package sz.sapphirex.pokedex.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil.compose.AsyncImage
import sz.sapphirex.pokedex.domain.model.simple.pokemon.SimplePokemon
import sz.sapphirex.pokedex.presentation.screens.pokemon.PokemonScreen
import sz.sapphirex.pokedex.presentation.utils.toColor
import sz.sapphirex.pokedex.presentation.utils.toNameCase

@Composable
fun PokemonCard(pokemon: SimplePokemon, padding: PaddingValues) {
    val navigator = LocalNavigator.currentOrThrow
    Surface(
        color = pokemon.types.toColor(),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clip(RoundedCornerShape(6.dp))
            .padding(padding)
        ,
        shape = RoundedCornerShape(6.dp),
        onClick = {
            navigator.push(PokemonScreen(pokemon))
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = pokemon.sprites.frontDefault,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentScale = ContentScale.FillHeight
            )
            Text(text = pokemon.name.toNameCase())
        }
    }
}