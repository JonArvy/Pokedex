package sz.sapphirex.pokedex.domain.model.base.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

@Serializable
data class NaturePokeathlonStatAffect(
    @SerialName("max_change") val maxChange: Int,
    val nature: NamedAPIResource
)

@Serializable
data class NaturePokeathlonStatAffectSets(
    val increase: List<NaturePokeathlonStatAffect>,
    val decrease: List<NaturePokeathlonStatAffect>
)

@Serializable
data class PokeathlonStat(
    val id: Int,
    val name: String,
    val names: List<Name>,
    @SerialName("affecting_natures") val affectingNatures: NaturePokeathlonStatAffectSets
)