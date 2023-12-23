package sz.sapphirex.pokedex.domain.model.dto.utility

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.APIResource
import sz.sapphirex.pokedex.domain.model.base.utility.Encounter
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

@Serializable
data class APIResourceDto(
    val url: String
)

@Serializable
data class DescriptionDto(
    val description: String,
    val language: NamedAPIResource
)

@Serializable
data class EffectDto(
    val effect: String,
    val language: NamedAPIResource
)

@Serializable
data class EncounterDto(
    @SerialName("min_level") val minLevel: Int,
    @SerialName("max_level") val maxLevel: Int,
    @SerialName("condition_values") val conditionValues: List<NamedAPIResource>,
    val chance: Int,
    val method: NamedAPIResource
)

@Serializable
data class FlavorTextDto(
    @SerialName("flavor_text") val flavorText: String,
    val language: NamedAPIResource,
    val version: NamedAPIResource,
)

@Serializable
data class GenerationGameIndexDto(
    @SerialName("game_index") val gameIndex: Int,
    val generation: NamedAPIResource
)

@Serializable
data class MachineVersionDetailDto(
    val machine: APIResource,
    @SerialName("version_group") val versionGroup: NamedAPIResource
)

@Serializable
data class NameDto(
    val name: String,
    val language: NamedAPIResource
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
    val language: NamedAPIResource,
)

@Serializable
data class VersionEncounterDetailDto(
    val version: NamedAPIResource,
    @SerialName("max_chance") val maxChance: Int,
    @SerialName("encounter_details") val encounterDetails: List<Encounter>
)

@Serializable
data class VersionGameIndexDto(
    @SerialName("game_index") val gameIndex: Int,
    val version: NamedAPIResource
)

@Serializable
data class VersionGroupFlavorTextDto(
    val text: String,
    val language: NamedAPIResource,
    @SerialName("version_group") val versionGroup: NamedAPIResource
)
