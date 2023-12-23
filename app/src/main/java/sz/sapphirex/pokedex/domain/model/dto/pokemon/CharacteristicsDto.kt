package sz.sapphirex.pokedex.domain.model.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.dto.utility.DescriptionDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NamedAPIResourceDto

@Serializable
data class CharacteristicDto(
    val id: Int,
    @SerialName("gene_modulo") val geneModulo: Int,
    @SerialName("possible_values") val possibleValues: List<Int>,
    @SerialName("highest_stat") val highestStat: NamedAPIResourceDto,
    val descriptions: List<DescriptionDto>
)
