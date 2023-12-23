package sz.sapphirex.pokedex.domain.model.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.dto.utility.APIResourceDto
import sz.sapphirex.pokedex.domain.model.dto.utility.DescriptionDto
import sz.sapphirex.pokedex.domain.model.dto.utility.FlavorTextDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NameDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NamedAPIResourceDto

@Serializable
data class PokemonSpeciesDto(
    val id: Int,
    val name: String,
    val order: Int,
    @SerialName("gender_rate") val genderRate: Int,
    @SerialName("capture_rate") val captureRate: Int,
    @SerialName("base_happiness") val baseHappiness: Int,
    @SerialName("is_baby") val isBaby: Boolean,
    @SerialName("is_legendary") val isLegendary: Boolean,
    @SerialName("is_mythical") val isMythical: Boolean,
    @SerialName("hatch_counter") val hatchCounter: Int,
    @SerialName("has_gender_differences") val hasGenderDifferences: Boolean,
    @SerialName("forms_switchable") val formsSwitchable: Boolean,
    @SerialName("growth_rate") val growthRate: NamedAPIResourceDto,
    @SerialName("pokedex_numbers") val pokedexNumbers: List<PokemonSpeciesDexEntryDto>,
    @SerialName("egg_groups") val eggGroups: List<NamedAPIResourceDto>,
    val color: NamedAPIResourceDto,
    val shape: NamedAPIResourceDto,
    @SerialName("evolves_from_species") val evolvesFromSpecies: NamedAPIResourceDto?,
    @SerialName("evolution_chain") val evolutionChain: APIResourceDto,
    val habitat: NamedAPIResourceDto,
    val generation: NamedAPIResourceDto,
    val names: List<NameDto>,
    @SerialName("pal_park_encounters") val palParkEncounters: List<PalParkEncounterAreaDto>,
    @SerialName("flavor_text_entries") val flavorTextEntries: List<FlavorTextDto>,
    @SerialName("form_descriptions") val formDescriptions: List<DescriptionDto>,
    val genera: List<GenusDto>,
    val varieties: List<PokemonSpeciesVarietyDto>
)

@Serializable
data class GenusDto(
    val genus: String,
    val language: NamedAPIResourceDto
)

@Serializable
data class PalParkEncounterAreaDto(
    @SerialName("base_score") val baseScore: Int,
    val rate: Int,
    val area: NamedAPIResourceDto
)

@Serializable
data class PokemonSpeciesDexEntryDto(
    @SerialName("entry_number") val entryNumber: Int,
    val pokedex: NamedAPIResourceDto
)

@Serializable
data class PokemonSpeciesVarietyDto(
    @SerialName("is_default")
    val isDefault: Boolean,
    val pokemon: NamedAPIResourceDto
)