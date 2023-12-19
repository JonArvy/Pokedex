package sz.sapphirex.pokedex.domain.model.base.pokemon.genders

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Gender(
    val id: Int,
    val name: String,
    @SerialName("pokemon_species_details")
    val pokemonSpeciesDetails: List<PokemonSpeciesGender>,
    @SerialName("required_for_evolution")
    val requiredForEvolution: List<NamedAPIResource>
)