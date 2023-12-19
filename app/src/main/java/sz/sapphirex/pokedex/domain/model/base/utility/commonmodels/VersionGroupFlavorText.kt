package sz.sapphirex.pokedex.domain.model.base.utility.commonmodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionGroupFlavorText(
    val text: String,
    val language: NamedAPIResource,
    @SerialName("version_group") val versionGroup: NamedAPIResource
)
