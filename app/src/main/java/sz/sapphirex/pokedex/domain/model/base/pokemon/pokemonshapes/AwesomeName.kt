package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemonshapes

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AwesomeName(
    @SerialName("awesome_name")
    val awesomeName: String,
    val language: NamedAPIResource
)