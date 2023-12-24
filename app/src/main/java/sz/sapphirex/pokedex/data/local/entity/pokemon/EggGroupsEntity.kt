package sz.sapphirex.pokedex.data.local.entity.pokemon

import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class EggGroupEntity(
    val id: Int,
    val name: String,
    val names: List<NameEntity>,
    val pokemonSpecies: List<NamedAPIResourceEntity>
)
