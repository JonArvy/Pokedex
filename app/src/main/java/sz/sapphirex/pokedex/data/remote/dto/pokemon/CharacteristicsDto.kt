package sz.sapphirex.pokedex.data.remote.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.remote.dto.utility.DescriptionDto
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto

@Serializable
data class CharacteristicDto(
    val id: Int,
    @SerialName("gene_modulo") val geneModulo: Int,
    @SerialName("possible_values") val possibleValues: List<Int>,
    @SerialName("highest_stat") val highestStat: NamedAPIResourceDto,
    val descriptions: List<DescriptionDto>
)
