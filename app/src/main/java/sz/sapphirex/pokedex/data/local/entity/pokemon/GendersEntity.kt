package sz.sapphirex.pokedex.data.local.entity.pokemon

import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class GenderEntity(
    val id: Int,
    val name: String,
    val pokemonSpeciesDetails: List<PokemonSpeciesGenderEntity>,
    val requiredForEvolution: List<NamedAPIResourceEntity>
)

data class PokemonSpeciesGenderEntity(
    val rate: Int,
    val pokemonSpecies: NamedAPIResourceEntity
)
