package sz.sapphirex.pokedex.domain.model.dto.games

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.games.PokemonEntry
import sz.sapphirex.pokedex.domain.model.base.utility.Description
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

@Serializable
data class PokedexDto(
    val id: Int,
    val name: String,
    @SerialName("is_main_series") val isMainSeries: Boolean,
    val descriptions: List<Description>,
    val names: List<Name>,
    @SerialName("pokemon_entries") val pokemonEntries: List<PokemonEntry>,
    val region: NamedAPIResource,
    @SerialName("version_groups") val versionGroups: List<NamedAPIResource>
)

@Serializable
data class PokemonEntryDto(
    @SerialName("entry_number") val entryNumber: Int,
    @SerialName("pokemon_species") val pokemonSpecies: NamedAPIResource
)