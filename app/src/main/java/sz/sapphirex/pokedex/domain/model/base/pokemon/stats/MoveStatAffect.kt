package sz.sapphirex.pokedex.domain.model.base.pokemon.stats

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.Serializable

@Serializable
data class MoveStatAffect(
    val change: Int,
    val move: NamedAPIResource
)