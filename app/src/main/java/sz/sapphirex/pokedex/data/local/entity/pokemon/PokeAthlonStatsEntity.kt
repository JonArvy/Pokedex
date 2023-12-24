package sz.sapphirex.pokedex.data.local.entity.pokemon

import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class NaturePokeathlonStatAffectEntity(
    val maxChange: Int,
    val nature: NamedAPIResourceEntity
)

data class NaturePokeathlonStatAffectSetsEntity(
    val increase: List<NaturePokeathlonStatAffectEntity>,
    val decrease: List<NaturePokeathlonStatAffectEntity>
)

data class PokeathlonStatEntity(
    val id: Int,
    val name: String,
    val names: List<NameEntity>,
    val affectingNatures: NaturePokeathlonStatAffectSetsEntity
)
