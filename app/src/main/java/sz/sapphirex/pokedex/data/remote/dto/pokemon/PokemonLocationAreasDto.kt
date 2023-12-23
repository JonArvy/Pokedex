package sz.sapphirex.pokedex.data.remote.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto
import sz.sapphirex.pokedex.data.remote.dto.utility.VersionEncounterDetailDto

@Serializable
data class LocationAreaEncounterDto(
    @SerialName("location_area") val locationArea: NamedAPIResourceDto,
    @SerialName("version_details")
    val versionDetails: List<VersionEncounterDetailDto>
)