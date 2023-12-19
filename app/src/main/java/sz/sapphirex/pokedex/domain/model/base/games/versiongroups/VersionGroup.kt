package sz.sapphirex.pokedex.domain.model.base.games.versiongroups

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionGroup(
    val id: Int,
    val name: String,
    val order: Int,
    val generation: NamedAPIResource,
    @SerialName("move_learn_methods") val moveLearnMethods: List<NamedAPIResource>,
    val pokedexes: List<NamedAPIResource>,
    val regions: List<NamedAPIResource>,
    val versions: List<NamedAPIResource>
)