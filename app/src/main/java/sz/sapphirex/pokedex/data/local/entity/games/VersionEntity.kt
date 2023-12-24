package sz.sapphirex.pokedex.data.local.entity.games

import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class VersionEntity(
    val id: Int,
    val name: String,
    val names: List<NameEntity>,
    val versionGroup: NamedAPIResourceEntity
)
