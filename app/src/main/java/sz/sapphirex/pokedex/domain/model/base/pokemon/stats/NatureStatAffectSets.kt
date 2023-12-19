package sz.sapphirex.pokedex.domain.model.base.pokemon.stats

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.Serializable

@Serializable
data class NatureStatAffectSets(
    val increase: List<NamedAPIResource>,
    val decrease: List<NamedAPIResource>
)