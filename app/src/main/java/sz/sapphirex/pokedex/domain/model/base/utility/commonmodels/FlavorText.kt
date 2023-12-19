package sz.sapphirex.pokedex.domain.model.base.utility.commonmodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource

@Serializable
data class FlavorText(
    @SerialName("flavor_text") val flavorText: String,
    val language: NamedAPIResource,
    val version: NamedAPIResource,
)