package sz.sapphirex.pokedex.domain.model.base.utility.commonmodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionGameIndex(
    @SerialName("game_index") val gameIndex: Int,
    val version: NamedAPIResource
)
