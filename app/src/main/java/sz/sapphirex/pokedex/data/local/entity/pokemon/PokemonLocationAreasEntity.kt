package sz.sapphirex.pokedex.data.local.entity.pokemon

import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity
import sz.sapphirex.pokedex.data.local.entity.utility.VersionEncounterDetailEntity

data class LocationAreaEncounterEntity(
    val locationArea: NamedAPIResourceEntity,
    val versionDetails: List<VersionEncounterDetailEntity>
)
