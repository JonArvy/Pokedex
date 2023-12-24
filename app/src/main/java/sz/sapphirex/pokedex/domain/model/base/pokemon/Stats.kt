package sz.sapphirex.pokedex.domain.model.base.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.APIResource
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class Stat(
    val id: Int,
    val name: String,
    val gameIndex: Int,
    val isBattleOnly: Boolean,
    val affectingMoves: MoveStatAffectSets,
    val affectingNatures: NatureStatAffectSets,
    val characteristics: List<APIResource>,
    val moveDamageClass: NamedAPIResource,
    val names: List<Name>
)

data class MoveStatAffect(
    val change: Int,
    val move: NamedAPIResource
)

data class MoveStatAffectSets(
    val increase: List<MoveStatAffect>,
    val decrease: List<MoveStatAffect>
)

data class NatureStatAffectSets(
    val increase: List<NamedAPIResource>,
    val decrease: List<NamedAPIResource>
)