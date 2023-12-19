package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionGameIndex(
    @SerialName("game_index") val gameIndex: Int,
    val version: NamedAPIResource
)