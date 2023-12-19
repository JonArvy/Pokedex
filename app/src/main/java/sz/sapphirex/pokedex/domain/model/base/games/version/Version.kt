package sz.sapphirex.pokedex.domain.model.base.games.version

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Name
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Version(
    val id: Int,
    val name: String,
    val names: List<Name>,
    @SerialName("version_group") val versionGroup: NamedAPIResource
)
