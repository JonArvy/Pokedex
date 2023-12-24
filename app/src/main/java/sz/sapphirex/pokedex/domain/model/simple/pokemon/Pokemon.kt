package sz.sapphirex.pokedex.domain.model.simple.pokemon

import androidx.room.PrimaryKey
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonSprites

data class SimplePokemon(
    val id: Int,
    val name: String,
    val sprites: PokemonSprites,
)

fun Pokemon.toSimple(): SimplePokemon {
    return SimplePokemon(
        id = id,
        name = name,
        sprites = sprites
    )
}