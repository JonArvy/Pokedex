package sz.sapphirex.pokedex.domain.model.base.pokemon.pokeathlonstats

import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.pokemon.pokeathlonstats.NaturePokeathlonStatAffect

@Serializable
data class NaturePokeathlonStatAffectSets(
    val increase: List<NaturePokeathlonStatAffect>,
    val decrease: List<NaturePokeathlonStatAffect>
)