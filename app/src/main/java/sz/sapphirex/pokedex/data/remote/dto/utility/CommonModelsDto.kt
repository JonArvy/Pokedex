package sz.sapphirex.pokedex.data.remote.dto.utility

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity
import sz.sapphirex.pokedex.domain.model.base.utility.APIResource
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource
import sz.sapphirex.pokedex.domain.model.base.utility.VersionGameIndex

@Serializable
data class APIResourceDto(
    val url: String
) {
    fun toBase(): APIResource {
        return APIResource(url = url)
    }
}

@Serializable
data class DescriptionDto(
    val description: String,
    val language: NamedAPIResourceDto
)

@Serializable
data class EffectDto(
    val effect: String,
    val language: NamedAPIResourceDto
)

@Serializable
data class EncounterDto(
    @SerialName("min_level") val minLevel: Int,
    @SerialName("max_level") val maxLevel: Int,
    @SerialName("condition_values") val conditionValues: List<NamedAPIResourceDto>,
    val chance: Int,
    val method: NamedAPIResourceDto
)

@Serializable
data class FlavorTextDto(
    @SerialName("flavor_text") val flavorText: String,
    val language: NamedAPIResourceDto,
    val version: NamedAPIResourceDto,
)

@Serializable
data class GenerationGameIndexDto(
    @SerialName("game_index") val gameIndex: Int,
    val generation: NamedAPIResourceDto
)

@Serializable
data class MachineVersionDetailDto(
    val machine: APIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
)

@Serializable
data class NameDto(
    val name: String,
    val language: NamedAPIResourceDto
)

@Serializable
data class NamedAPIResourceDto(
    val name: String,
    val url: String
) {
    fun toBase(): NamedAPIResource {
        return NamedAPIResource(
            name = name,
            url = url
        )
    }

    fun toEntity(): NamedAPIResourceEntity {
        return NamedAPIResourceEntity(
            name = name,
            url = url
        )
    }
}

@Serializable
data class VerboseEffectDto(
    val effect: String,
    @SerialName("short_effect") val shortEffect: String,
    val language: NamedAPIResourceDto,
)

@Serializable
data class VersionEncounterDetailDto(
    val version: NamedAPIResourceDto,
    @SerialName("max_chance") val maxChance: Int,
    @SerialName("encounter_details") val encounterDetails: List<EncounterDto>
)

@Serializable
data class VersionGameIndexDto(
    @SerialName("game_index") val gameIndex: Int,
    val version: NamedAPIResourceDto
) {
    fun toBase(): VersionGameIndex {
        return VersionGameIndex(
            gameIndex = gameIndex,
            version = version.toBase()
        )
    }
}

@Serializable
data class VersionGroupFlavorTextDto(
    val text: String,
    val language: NamedAPIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
)
