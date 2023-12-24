package sz.sapphirex.pokedex.domain.model.base.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.APIResource
import sz.sapphirex.pokedex.domain.model.base.utility.Description
import sz.sapphirex.pokedex.domain.model.base.utility.FlavorText
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class PokemonSpecies(
    val id: Int,
    val name: String,
    val order: Int,
    val genderRate: Int,
    val captureRate: Int,
    val baseHappiness: Int,
    val isBaby: Boolean,
    val isLegendary: Boolean,
    val isMythical: Boolean,
    val hatchCounter: Int,
    val hasGenderDifferences: Boolean,
    val formsSwitchable: Boolean,
    val growthRate: NamedAPIResource,
    val pokedexNumbers: List<PokemonSpeciesDexEntry>,
    val eggGroups: List<NamedAPIResource>,
    val color: NamedAPIResource,
    val shape: NamedAPIResource,
    val evolvesFromSpecies: NamedAPIResource?,
    val evolutionChain: APIResource,
    val habitat: NamedAPIResource,
    val generation: NamedAPIResource,
    val names: List<Name>,
    val palParkEncounters: List<PalParkEncounterArea>,
    val flavorTextEntries: List<FlavorText>,
    val formDescriptions: List<Description>,
    val genera: List<Genus>,
    val varieties: List<PokemonSpeciesVariety>
)

data class Genus(
    val genus: String,
    val language: NamedAPIResource
)

data class PalParkEncounterArea(
    val baseScore: Int,
    val rate: Int,
    val area: NamedAPIResource
)

data class PokemonSpeciesDexEntry(
    val entryNumber: Int,
    val pokedex: NamedAPIResource
)

data class PokemonSpeciesVariety(
    val isDefault: Boolean,
    val pokemon: NamedAPIResource
)