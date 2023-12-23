package sz.sapphirex.pokedex.data.remote.dto.games

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.remote.dto.utility.NameDto
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto

@Serializable
data class VersionDto(
    val id: Int,
    val name: String,
    val names: List<NameDto>,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
)
