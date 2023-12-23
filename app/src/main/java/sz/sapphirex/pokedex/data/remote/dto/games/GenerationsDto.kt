package sz.sapphirex.pokedex.data.remote.dto.games

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.remote.dto.utility.NameDto
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto

@Serializable
data class GenerationDto(
    val id: Int,
    val name: String,
    val abilities: List<NamedAPIResourceDto>,
    val names: List<NameDto>,
    @SerialName("main_region") val mainRegion: NamedAPIResourceDto,
    val moves: List<NamedAPIResourceDto>,
    @SerialName("pokemon_species") val pokemonSpecies: List<NamedAPIResourceDto>,
    val types: List<NamedAPIResourceDto>,
    @SerialName("version_groups") val versionGroups: List<NamedAPIResourceDto>
)