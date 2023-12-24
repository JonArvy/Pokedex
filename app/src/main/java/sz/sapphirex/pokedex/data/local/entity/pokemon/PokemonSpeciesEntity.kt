package sz.sapphirex.pokedex.data.local.entity.pokemon

import sz.sapphirex.pokedex.data.local.entity.utility.APIResourceEntity
import sz.sapphirex.pokedex.data.local.entity.utility.DescriptionEntity
import sz.sapphirex.pokedex.data.local.entity.utility.FlavorTextEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class PokemonSpeciesEntity(
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
    val growthRate: NamedAPIResourceEntity,
    val pokedexNumbers: List<PokemonSpeciesDexEntryEntity>,
    val eggGroups: List<NamedAPIResourceEntity>,
    val color: NamedAPIResourceEntity,
    val shape: NamedAPIResourceEntity,
    val evolvesFromSpecies: NamedAPIResourceEntity?,
    val evolutionChain: APIResourceEntity,
    val habitat: NamedAPIResourceEntity,
    val generation: NamedAPIResourceEntity,
    val names: List<NameEntity>,
    val palParkEncounters: List<PalParkEncounterAreaEntity>,
    val flavorTextEntries: List<FlavorTextEntity>,
    val formDescriptions: List<DescriptionEntity>,
    val genera: List<GenusEntity>,
    val varieties: List<PokemonSpeciesVarietyEntity>
)

data class GenusEntity(
    val genus: String,
    val language: NamedAPIResourceEntity
)

data class PalParkEncounterAreaEntity(
    val baseScore: Int,
    val rate: Int,
    val area: NamedAPIResourceEntity
)

data class PokemonSpeciesDexEntryEntity(
    val entryNumber: Int,
    val pokedex: NamedAPIResourceEntity
)

data class PokemonSpeciesVarietyEntity(
    val isDefault: Boolean,
    val pokemon: NamedAPIResourceEntity
)