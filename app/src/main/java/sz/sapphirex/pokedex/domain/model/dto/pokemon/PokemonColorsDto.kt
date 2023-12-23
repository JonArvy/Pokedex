package sz.sapphirex.pokedex.domain.model.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.dto.utility.NameDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NamedAPIResourceDto

@Serializable
data class PokemonColorDto(
    val id: Int,
    val name: String,
    val names: List<NameDto>,
    @SerialName("pokemon_species") val pokemonSpecies: List<NamedAPIResourceDto>
)