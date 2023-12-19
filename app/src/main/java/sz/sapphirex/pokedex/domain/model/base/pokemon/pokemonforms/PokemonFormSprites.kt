package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemonforms

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonFormSprites(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_shiny") val backShiny: String
)