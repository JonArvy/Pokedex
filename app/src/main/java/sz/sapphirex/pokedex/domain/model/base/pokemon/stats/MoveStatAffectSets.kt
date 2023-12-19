package sz.sapphirex.pokedex.domain.model.base.pokemon.stats

import kotlinx.serialization.Serializable

@Serializable
data class MoveStatAffectSets(
    val increase: List<MoveStatAffect>,
    val decrease: List<MoveStatAffect>
)