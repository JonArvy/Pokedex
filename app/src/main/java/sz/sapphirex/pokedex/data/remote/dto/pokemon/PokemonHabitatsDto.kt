package sz.sapphirex.pokedex.data.remote.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.remote.dto.utility.NameDto
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto

@Serializable
data class PokemonHabitatDto(
    val id: Int,
    val name: String,
    val names: List<NameDto>,
    @SerialName("pokemon_species") val pokemonSpecies: List<NamedAPIResourceDto>
)