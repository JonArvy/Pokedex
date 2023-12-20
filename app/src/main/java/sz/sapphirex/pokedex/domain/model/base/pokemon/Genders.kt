package sz.sapphirex.pokedex.domain.model.base.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

@Serializable
data class Gender(
    val id: Int,
    val name: String,
    @SerialName("pokemon_species_details")
    val pokemonSpeciesDetails: List<PokemonSpeciesGender>,
    @SerialName("required_for_evolution")
    val requiredForEvolution: List<NamedAPIResource>
)

@Serializable
data class PokemonSpeciesGender(
    val rate: Int,
    @SerialName("pokemon_species")
    val pokemonSpecies: NamedAPIResource
)