package sz.sapphirex.pokedex.presentation.utils

import androidx.compose.ui.graphics.Color
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonType

fun List<PokemonType>.toColor(): Color {
    val color: Long = when (this.first().type.name) {
        "normal" -> 0xFFA8A77A
        "fire" -> 0xFFEE8130
        "water" -> 0xFF6390F0
        "electric" -> 0xFFF7D02C
        "grass" -> 0xFF7AC74C
        "ice" -> 0xFF96D9D6
        "fighting" -> 0xFFC22E28
        "poison" -> 0xFFA33EA1
        "ground" -> 0xFFE2BF65
        "flying" -> 0xFFA98FF3
        "psychic" -> 0xFFF95587
        "bug" -> 0xFFA6B91A
        "rock" -> 0xFFB6A136
        "ghost" -> 0xFF735797
        "dragon" -> 0xFF6F35FC
        "dark" -> 0xFF705746
        "steel" -> 0xFFB7B7CE
        "fairy" -> 0xFFD685AD
        else -> 0xFFFFFFFF
    }
    return Color(color)
}

fun String.toNameCase(): String {
    return this.split(" ").joinToString(",") {
        it.replaceFirstChar(Char::titlecase)
    }
}