package sz.sapphirex.pokedex.data.local.entity.utility

import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource
import sz.sapphirex.pokedex.domain.model.base.utility.VersionGameIndex

data class APIResourceEntity(
    val url: String
)

data class DescriptionEntity(
    val description: String,
    val language: NamedAPIResourceEntity
)

data class EffectEntity(
    val effect: String,
    val language: NamedAPIResourceEntity
)

data class EncounterEntity(
    val minLevel: Int,
    val maxLevel: Int,
    val conditionValues: List<NamedAPIResourceEntity>,
    val chance: Int,
    val method: NamedAPIResourceEntity
)

data class FlavorTextEntity(
    val flavorText: String,
    val language: NamedAPIResourceEntity,
    val version: NamedAPIResourceEntity
)

data class GenerationGameIndexEntity(
    val gameIndex: Int,
    val generation: NamedAPIResourceEntity
)

data class MachineVersionDetailEntity(
    val machine: APIResourceEntity,
    val versionGroup: NamedAPIResourceEntity
)

data class NameEntity(
    val name: String,
    val language: NamedAPIResourceEntity
)

data class NamedAPIResourceEntity(
    val name: String,
    val url: String
) {
    fun toBase(): NamedAPIResource {
        return NamedAPIResource(
            name = name,
            url = url
        )
    }
}

data class VerboseEffectEntity(
    val effect: String,
    val shortEffect: String,
    val language: NamedAPIResourceEntity
)

data class VersionEncounterDetailEntity(
    val version: NamedAPIResourceEntity,
    val maxChance: Int,
    val encounterDetails: List<EncounterEntity>
)

data class VersionGameIndexEntity(
    val gameIndex: Int,
    val version: NamedAPIResourceEntity
) {
    fun toBase(): VersionGameIndex {
        return VersionGameIndex(
            gameIndex = gameIndex,
            version = version.toBase()
        )
    }
}

data class VersionGroupFlavorTextEntity(
    val text: String,
    val language: NamedAPIResourceEntity,
    val versionGroup: NamedAPIResourceEntity
)
