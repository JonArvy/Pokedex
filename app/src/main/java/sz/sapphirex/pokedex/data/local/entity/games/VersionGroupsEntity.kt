package sz.sapphirex.pokedex.data.local.entity.games

import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class VersionGroupEntity(
    val id: Int,
    val name: String,
    val order: Int,
    val generation: NamedAPIResourceEntity,
    val moveLearnMethods: List<NamedAPIResourceEntity>,
    val pokedexes: List<NamedAPIResourceEntity>,
    val regions: List<NamedAPIResourceEntity>,
    val versions: List<NamedAPIResourceEntity>
)
