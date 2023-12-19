package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemonspecies

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.APIResource
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Description
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.FlavorText
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Name
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpecies(
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
    @SerialName("growth_rate") val growthRate: NamedAPIResource,
    @SerialName("pokedex_numbers") val pokedexNumbers: List<PokemonSpeciesDexEntry>,
    @SerialName("egg_groups") val eggGroups: List<NamedAPIResource>,
    val color: NamedAPIResource,
    val shape: NamedAPIResource,
    @SerialName("evolves_from_species") val evolvesFromSpecies: NamedAPIResource?,
    @SerialName("evolution_chain") val evolutionChain: APIResource,
    val habitat: NamedAPIResource,
    val generation: NamedAPIResource,
    val names: List<Name>,
    @SerialName("pal_park_encounters") val palParkEncounters: List<PalParkEncounterArea>,
    @SerialName("flavor_text_entries") val flavorTextEntries: List<FlavorText>,
    @SerialName("form_descriptions") val formDescriptions: List<Description>,
    val genera: List<Genus>,
    val varieties: List<PokemonSpeciesVariety>
)