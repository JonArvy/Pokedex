package sz.sapphirex.pokedex.data.local.entity.games

import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class GenerationEntity(
    val id: Int,
    val name: String,
    val abilities: List<NamedAPIResourceEntity>,
    val names: List<NameEntity>,
    val mainRegion: NamedAPIResourceEntity,
    val moves: List<NamedAPIResourceEntity>,
    val pokemonSpecies: List<NamedAPIResourceEntity>,
    val types: List<NamedAPIResourceEntity>,
    val versionGroups: List<NamedAPIResourceEntity>
)