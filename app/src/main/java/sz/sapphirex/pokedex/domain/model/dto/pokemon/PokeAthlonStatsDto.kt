package sz.sapphirex.pokedex.domain.model.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.dto.utility.NameDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NamedAPIResourceDto

@Serializable
data class NaturePokeathlonStatAffectDto(
    @SerialName("max_change") val maxChange: Int,
    val nature: NamedAPIResourceDto
)

@Serializable
data class NaturePokeathlonStatAffectSetsDto(
    val increase: List<NaturePokeathlonStatAffectDto>,
    val decrease: List<NaturePokeathlonStatAffectDto>
)

@Serializable
data class PokeathlonStatDto(
    val id: Int,
    val name: String,
    val names: List<NameDto>,
    @SerialName("affecting_natures") val affectingNatures: NaturePokeathlonStatAffectSetsDto
)