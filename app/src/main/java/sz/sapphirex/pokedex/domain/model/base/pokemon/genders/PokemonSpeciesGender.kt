package sz.sapphirex.pokedex.domain.model.base.pokemon.genders

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesGender(
    val rate: Int,
    @SerialName("pokemon_species")
    val pokemonSpecies: NamedAPIResource
)