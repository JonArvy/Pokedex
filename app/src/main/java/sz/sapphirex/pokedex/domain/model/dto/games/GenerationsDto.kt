package sz.sapphirex.pokedex.domain.model.dto.games

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

@Serializable
data class GenerationDto(
    val id: Int,
    val name: String,
    val abilities: List<NamedAPIResource>,
    val names: List<Name>,
    @SerialName("main_region") val mainRegion: NamedAPIResource,
    val moves: List<NamedAPIResource>,
    @SerialName("pokemon_species") val pokemonSpecies: List<NamedAPIResource>,
    val types: List<NamedAPIResource>,
    @SerialName("version_groups") val versionGroups: List<NamedAPIResource>
)