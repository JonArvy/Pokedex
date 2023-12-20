package sz.sapphirex.pokedex.domain.model.base.games

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

@Serializable
data class Version(
    val id: Int,
    val name: String,
    val names: List<Name>,
    @SerialName("version_group") val versionGroup: NamedAPIResource
)
