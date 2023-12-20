package sz.sapphirex.pokedex.domain.model.base.utility

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class APIResource(
    val url: String
)

@Serializable
data class Description(
    val description: String,
    val language: NamedAPIResource
)

@Serializable
data class Effect(
    val effect: String,
    val language: NamedAPIResource
)

@Serializable
data class Encounter(
    @SerialName("min_level") val minLevel: Int,
    @SerialName("max_level") val maxLevel: Int,
    @SerialName("condition_values") val conditionValues: List<NamedAPIResource>,
    val chance: Int,
    val method: NamedAPIResource
)

@Serializable
data class FlavorText(
    @SerialName("flavor_text") val flavorText: String,
    val language: NamedAPIResource,
    val version: NamedAPIResource,
)

@Serializable
data class GenerationGameIndex(
    @SerialName("game_index") val gameIndex: Int,
    val generation: NamedAPIResource
)

@Serializable
data class MachineVersionDetail(
    val machine: APIResource,
    @SerialName("version_group") val versionGroup: NamedAPIResource
)

@Serializable
data class Name(
    val name: String,
    val language: NamedAPIResource
)

@Serializable
data class NamedAPIResource(
    val name: String,
    val url: String
)

@Serializable
data class VerboseEffect(
    val effect: String,
    @SerialName("short_effect") val shortEffect: String,
    val language: NamedAPIResource,
)

@Serializable
data class VersionEncounterDetail(
    val version: NamedAPIResource,
    @SerialName("max_chance") val maxChance: Int,
    @SerialName("encounter_details") val encounterDetails: List<Encounter>
)

@Serializable
data class VersionGameIndex(
    @SerialName("game_index") val gameIndex: Int,
    val version: NamedAPIResource
)

@Serializable
data class VersionGroupFlavorText(
    val text: String,
    val language: NamedAPIResource,
    @SerialName("version_group") val versionGroup: NamedAPIResource
)
