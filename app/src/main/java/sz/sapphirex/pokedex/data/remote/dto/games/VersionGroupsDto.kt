package sz.sapphirex.pokedex.data.remote.dto.games

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto

@Serializable
data class VersionGroupDto(
    val id: Int,
    val name: String,
    val order: Int,
    val generation: NamedAPIResourceDto,
    @SerialName("move_learn_methods") val moveLearnMethods: List<NamedAPIResourceDto>,
    val pokedexes: List<NamedAPIResourceDto>,
    val regions: List<NamedAPIResourceDto>,
    val versions: List<NamedAPIResourceDto>
)