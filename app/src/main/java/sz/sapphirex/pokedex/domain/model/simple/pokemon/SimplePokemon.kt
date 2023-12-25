package sz.sapphirex.pokedex.domain.model.simple.pokemon

import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonSprites
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonType

data class SimplePokemon(
    val id: Int,
    val name: String,
    val sprites: PokemonSprites,
    val types: List<PokemonType>
)

fun Pokemon.toSimple(): SimplePokemon {
    return SimplePokemon(
        id = id,
        name = name,
        sprites = sprites,
        types = types,
    )
}