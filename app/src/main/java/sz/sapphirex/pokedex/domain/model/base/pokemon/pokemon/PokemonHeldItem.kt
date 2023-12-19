package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonHeldItem(
    val item: NamedAPIResource,
    @SerialName("version_details") val versionDetails: List<PokemonHeldItemVersion>
)