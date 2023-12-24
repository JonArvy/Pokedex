package sz.sapphirex.pokedex.domain.model.base.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class Gender(
    val id: Int,
    val name: String,
    val pokemonSpeciesDetails: List<PokemonSpeciesGender>,
    val requiredForEvolution: List<NamedAPIResource>
)

data class PokemonSpeciesGender(
    val rate: Int,
    val pokemonSpecies: NamedAPIResource
)