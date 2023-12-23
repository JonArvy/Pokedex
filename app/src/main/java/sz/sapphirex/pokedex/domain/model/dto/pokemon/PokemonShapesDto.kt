package sz.sapphirex.pokedex.domain.model.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.dto.utility.NameDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NamedAPIResourceDto

@Serializable
data class AwesomeNameDto(
    @SerialName("awesome_name")
    val awesomeName: String,
    val language: NamedAPIResourceDto
)

@Serializable
data class PokemonShapeDto(
    val id: Int,
    val name: String,
    @SerialName("awesome_names") val awesomeNames: List<AwesomeNameDto>,
    val names: List<NameDto>,
    @SerialName("pokemon_species") val pokemonSpecies: List<NamedAPIResourceDto>
)