package sz.sapphirex.pokedex.domain.model.base.utility

import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity
import sz.sapphirex.pokedex.data.local.entity.utility.VersionGameIndexEntity

data class APIResource(
    val url: String
)

data class Description(
    val description: String,
    val language: NamedAPIResource
)

data class Effect(
    val effect: String,
    val language: NamedAPIResource
)

data class Encounter(
    val minLevel: Int,
    val maxLevel: Int,
    val conditionValues: List<NamedAPIResource>,
    val chance: Int,
    val method: NamedAPIResource
)

data class FlavorText(
    val flavorText: String,
    val language: NamedAPIResource,
    val version: NamedAPIResource,
)

data class GenerationGameIndex(
    val gameIndex: Int,
    val generation: NamedAPIResource
)

data class MachineVersionDetail(
    val machine: APIResource,
    val versionGroup: NamedAPIResource
)

data class Name(
    val name: String,
    val language: NamedAPIResource
)

data class NamedAPIResource(
    val name: String,
    val url: String
) {
    fun toEntity(): NamedAPIResourceEntity {
        return NamedAPIResourceEntity(
            name = name,
            url = url
        )
    }
}

data class VerboseEffect(
    val effect: String,
    val shortEffect: String,
    val language: NamedAPIResource,
)

data class VersionEncounterDetail(
    val version: NamedAPIResource,
    val maxChance: Int,
    val encounterDetails: List<Encounter>
)

data class VersionGameIndex(
    val gameIndex: Int,
    val version: NamedAPIResource
) {
    fun toEntity(): VersionGameIndexEntity {
        return VersionGameIndexEntity(
            gameIndex = gameIndex,
            version = version.toEntity()
        )
    }
}

data class VersionGroupFlavorText(
    val text: String,
    val language: NamedAPIResource,
    val versionGroup: NamedAPIResource
)