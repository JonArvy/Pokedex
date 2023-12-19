package sz.sapphirex.pokedex.domain.model.base.utility.commonmodels

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource

@Serializable
data class Encounter(
    @SerialName("min_level") val minLevel: Int,
    @SerialName("max_level") val maxLevel: Int,
    @SerialName("condition_values") val conditionValues: List<NamedAPIResource>,
    val chance: Int,
    val method: NamedAPIResource
)