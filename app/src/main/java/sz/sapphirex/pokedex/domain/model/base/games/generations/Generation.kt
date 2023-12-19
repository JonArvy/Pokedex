package sz.sapphirex.pokedex.domain.model.base.games.generations

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Name
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Generation(
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