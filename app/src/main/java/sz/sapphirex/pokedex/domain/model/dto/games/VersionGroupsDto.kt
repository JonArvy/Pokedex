package sz.sapphirex.pokedex.domain.model.dto.games

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

@Serializable
data class VersionGroupDto(
    val id: Int,
    val name: String,
    val order: Int,
    val generation: NamedAPIResource,
    @SerialName("move_learn_methods") val moveLearnMethods: List<NamedAPIResource>,
    val pokedexes: List<NamedAPIResource>,
    val regions: List<NamedAPIResource>,
    val versions: List<NamedAPIResource>
)