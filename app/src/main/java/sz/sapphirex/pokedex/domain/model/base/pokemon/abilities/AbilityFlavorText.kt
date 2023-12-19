package sz.sapphirex.pokedex.domain.model.base.pokemon.abilities

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityFlavorText(
    @SerialName("flavor_text") val flavorText: String,
    val language: NamedAPIResource,
    @SerialName("version_group") val versionGroup: NamedAPIResource
)
