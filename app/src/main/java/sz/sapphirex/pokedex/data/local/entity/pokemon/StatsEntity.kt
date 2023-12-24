package sz.sapphirex.pokedex.data.local.entity.pokemon

import sz.sapphirex.pokedex.data.local.entity.utility.APIResourceEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class StatEntity(
    val id: Int,
    val name: String,
    val gameIndex: Int,
    val isBattleOnly: Boolean,
    val affectingMoves: MoveStatAffectSetsEntity,
    val affectingNatures: NatureStatAffectSetsEntity,
    val characteristics: List<APIResourceEntity>,
    val moveDamageClass: NamedAPIResourceEntity,
    val names: List<NameEntity>
)

data class MoveStatAffectEntity(
    val change: Int,
    val move: NamedAPIResourceEntity
)

data class MoveStatAffectSetsEntity(
    val increase: List<MoveStatAffectEntity>,
    val decrease: List<MoveStatAffectEntity>
)

data class NatureStatAffectSetsEntity(
    val increase: List<NamedAPIResourceEntity>,
    val decrease: List<NamedAPIResourceEntity>
)