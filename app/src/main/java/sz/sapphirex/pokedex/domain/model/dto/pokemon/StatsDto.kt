package sz.sapphirex.pokedex.domain.model.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.dto.utility.APIResourceDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NameDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NamedAPIResourceDto

@Serializable
data class StatDto(
    val id: Int,
    val name: String,
    @SerialName("game_index") val gameIndex: Int,
    @SerialName("is_battle_only") val isBattleOnly: Boolean,
    @SerialName("affecting_moves") val affectingMoves: MoveStatAffectSetsDto,
    @SerialName("affecting_natures") val affectingNatures: NatureStatAffectSetsDto,
    val characteristics: List<APIResourceDto>,
    @SerialName("move_damage_class") val moveDamageClass: NamedAPIResourceDto,
    val names: List<NameDto>
)

@Serializable
data class MoveStatAffectDto(
    val change: Int,
    val move: NamedAPIResourceDto
)

@Serializable
data class MoveStatAffectSetsDto(
    val increase: List<MoveStatAffectDto>,
    val decrease: List<MoveStatAffectDto>
)

@Serializable
data class NatureStatAffectSetsDto(
    val increase: List<NamedAPIResourceDto>,
    val decrease: List<NamedAPIResourceDto>
)