package sz.sapphirex.pokedex.presentation.screens.pokemon

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ChipColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import coil.compose.AsyncImage
import sz.sapphirex.pokedex.R
import sz.sapphirex.pokedex.domain.model.base.pokemon.Ability
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonAbility
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonType
import sz.sapphirex.pokedex.domain.model.simple.pokemon.SimplePokemon
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.presentation.components.widgets.TypeChip
import sz.sapphirex.pokedex.presentation.components.widgets.TypeChipBorder
import sz.sapphirex.pokedex.presentation.utils.toColor
import sz.sapphirex.pokedex.presentation.utils.toHeightWeightCase
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
                is DataResult.Success -> PokemonScreenContent(pokemon = data.data)
                is DataResult.Error -> Text(text = data.message)
                is DataResult.Loading -> PokemonScreenContent(simplePokemon = simplePokemon)
            }
        }
    }

    // For simple pokemon screen object
    @Composable
    fun PokemonScreenContent(simplePokemon: SimplePokemon) {
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
                    model = simplePokemon.sprites.other?.officialArtwork?.frontDefault,
                    contentDescription = simplePokemon.name,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

    // For pokemon screen object
    @Composable
    fun PokemonScreenContent(pokemon: Pokemon) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray),

//            color = pokemon.types.toColor()
        ) {
            PokemonPageTopBar(
                pokemonName = pokemon.name,
                pokemonId = pokemon.id
            )
            Column {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(.35f),
                    color = Color.Transparent
                ) {
                    
                }
                Surface(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                        .fillMaxWidth()
                        .weight(.66f),
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp),
                    shadowElevation = 8.dp,
                    tonalElevation = 8.dp
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        PokemonPageTypeList(pokemon.types)
                        Text(
                            text = "About",
                            color = pokemon.types[0].type.toColor(),
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                        PokemonPageAttributes(
                            pokemonWeight = pokemon.weight,
                            pokemonHeight = pokemon.height,
                            pokemonAbilities = pokemon.abilities
                        )
                    }
                }
            }
            AsyncImage(
//                model = pokemon.sprites.frontDefault,
                model = simplePokemon.sprites.other?.officialArtwork?.frontDefault,
                contentDescription = pokemon.name,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxWidth(.7f)
                    .aspectRatio(1f)
                    .align(Alignment.TopCenter)
                    .padding(top = 48.dp),
            )
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
            Box(
                modifier = Modifier.width(48.dp)
            ) {
                IconButton(
                    modifier = Modifier.size(48.dp),
                    onClick = { /*TODO*/ },
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                )
            }
            Text(text = pokemonName.toNameCase(), fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Box(
                modifier = Modifier.width(48.dp)
            ) {
                Text(
                    text = "#$pokemonId",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
    @Composable
    fun PokemonPageTypeList(pokemonTypes: List<PokemonType>) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            pokemonTypes.forEachIndexed { index, pokemonType ->
                TypeChip(
                    color = pokemonType.type.toColor(),
                    label = { Text(
                        text = pokemonType.type.name.toNameCase(),
                        color = MaterialTheme.colorScheme.surface,
                        fontWeight = FontWeight.Bold,
                    )},
                    border = TypeChipBorder.borderless()
                )
                if (index < pokemonTypes.size - 1) {
                    Spacer(Modifier.width(16.dp))
                }
            }
        }
    }

    @Composable
    fun PokemonPageAttributes(pokemonWeight: Int, pokemonHeight: Int, pokemonAbilities: List<PokemonAbility>) {
        Row(
            Modifier
            .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column {
                Row {
                    Icon(painter = painterResource(id = R.drawable.weight), contentDescription = "weight")
                    Text((pokemonWeight / 10.0).toHeightWeightCase())
                }
                Text(text = "Weight")
            }
            Column {
                Row {
                    Icon(painter = painterResource(id = R.drawable.straighten), contentDescription = "height")
                    Text((pokemonHeight / 10.0).toHeightWeightCase())
                }
                Text(text = "Height")
            }
            Column {
                pokemonAbilities.forEach { pokemonAbility ->
                    Text(text = pokemonAbility.ability.name)
                }
                Text(text = "Moves")
            }
        }
    }
}