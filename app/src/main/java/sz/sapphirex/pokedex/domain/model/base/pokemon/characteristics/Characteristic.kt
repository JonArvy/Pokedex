package sz.sapphirex.pokedex.domain.model.base.pokemon.characteristics

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Description
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Characteristic(
    val id: Int,
    @SerialName("gene_modulo") val geneModulo: Int,
    @SerialName("possible_values") val possibleValues: List<Int>,
    @SerialName("highest_stat") val highestStat: NamedAPIResource,
    val descriptions: List<Description>
)
