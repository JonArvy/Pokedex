package sz.sapphirex.pokedex.data.remote.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto

@Serializable
data class GenderDto(
    val id: Int,
    val name: String,
    @SerialName("pokemon_species_details")
    val pokemonSpeciesDetails: List<PokemonSpeciesGenderDto>,
    @SerialName("required_for_evolution")
    val requiredForEvolution: List<NamedAPIResourceDto>
)

@Serializable
data class PokemonSpeciesGenderDto(
    val rate: Int,
    @SerialName("pokemon_species")
    val pokemonSpecies: NamedAPIResourceDto
)