package sz.sapphirex.pokedex.domain.model.base.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.APIResource
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

@Serializable
data class Stat(
    val id: Int,
    val name: String,
    @SerialName("game_index") val gameIndex: Int,
    @SerialName("is_battle_only") val isBattleOnly: Boolean,
    @SerialName("affecting_moves") val affectingMoves: MoveStatAffectSets,
    @SerialName("affecting_natures") val affectingNatures: NatureStatAffectSets,
    val characteristics: List<APIResource>,
    @SerialName("move_damage_class") val moveDamageClass: NamedAPIResource,
    val names: List<Name>
)

@Serializable
data class MoveStatAffect(
    val change: Int,
    val move: NamedAPIResource
)

@Serializable
data class MoveStatAffectSets(
    val increase: List<MoveStatAffect>,
    val decrease: List<MoveStatAffect>
)

@Serializable
data class NatureStatAffectSets(
    val increase: List<NamedAPIResource>,
    val decrease: List<NamedAPIResource>
)