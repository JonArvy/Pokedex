package sz.sapphirex.pokedex.domain.model.base.utility.commonmodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MachineVersionDetail(
    val machine: APIResource,
    @SerialName("version_group") val versionGroup: NamedAPIResource
)