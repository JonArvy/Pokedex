package sz.sapphirex.pokedex.presentation.utils

import androidx.compose.ui.graphics.Color
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonType
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

private val colorMap = mapOf(
    "normal" to 0xFFA8A77A,
    "fire" to 0xFFEE8130,
    "water" to 0xFF6390F0,
    "electric" to 0xFFF7D02C,
    "grass" to 0xFF7AC74C,
    "ice" to 0xFF96D9D6,
    "fighting" to 0xFFC22E28,
    "poison" to 0xFFA33EA1,
    "ground" to 0xFFE2BF65,
    "flying" to 0xFFA98FF3,
    "psychic" to 0xFFF95587,
    "bug" to 0xFFA6B91A,
    "rock" to 0xFFB6A136,
    "ghost" to 0xFF735797,
    "dragon" to 0xFF6F35FC,
    "dark" to 0xFF705746,
    "steel" to 0xFFB7B7CE,
    "fairy" to 0xFFD685AD,
)

fun NamedAPIResource.toColor(): Color {
    val color: Long = colorMap[this.name] ?: 0xFFFFFFFF
    return Color(color)
}

fun List<PokemonType>.toColor(): Color {
    val color: Long = colorMap[this.first().type.name] ?: 0xFFFFFFFF
    return Color(color)
}

fun String.toMoveNameCase(): String {
    return this.replace("-", " ").toNameCase()
}

fun String.toNameCase(): String {
    return this.split(" ").joinToString(" ") {
        it.replaceFirstChar(Char::titlecase)
    }
}