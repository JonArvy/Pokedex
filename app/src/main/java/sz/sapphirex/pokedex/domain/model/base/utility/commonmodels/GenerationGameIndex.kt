package sz.sapphirex.pokedex.domain.model.base.utility.commonmodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource

@Serializable
data class GenerationGameIndex(
    @SerialName("game_index") val gameIndex: Int,
    val generation: NamedAPIResource
)