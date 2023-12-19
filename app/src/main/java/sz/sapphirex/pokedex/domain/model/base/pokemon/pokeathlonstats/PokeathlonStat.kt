package sz.sapphirex.pokedex.domain.model.base.pokemon.pokeathlonstats

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Name
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.pokemon.pokeathlonstats.NaturePokeathlonStatAffectSets

@Serializable
data class PokeathlonStat(
    val id: Int,
    val name: String,
    val names: List<Name>,
    @SerialName("affecting_natures") val affectingNatures: NaturePokeathlonStatAffectSets
)