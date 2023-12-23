package sz.sapphirex.pokedex.data.remote.dto.utility

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class APIResourceDto(
    val url: String
)

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
)

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
)

@Serializable
data class VersionGroupFlavorTextDto(
    val text: String,
    val language: NamedAPIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
)
