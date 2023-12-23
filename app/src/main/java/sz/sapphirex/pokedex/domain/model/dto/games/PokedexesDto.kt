package sz.sapphirex.pokedex.domain.model.dto.games

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.games.PokemonEntry
import sz.sapphirex.pokedex.domain.model.dto.utility.DescriptionDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NameDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NamedAPIResourceDto

@Serializable
data class PokedexDto(
    val id: Int,
    val name: String,
    @SerialName("is_main_series") val isMainSeries: Boolean,
    val descriptions: List<DescriptionDto>,
    val names: List<NameDto>,
    @SerialName("pokemon_entries") val pokemonEntries: List<PokemonEntry>,
    val region: NamedAPIResourceDto,
    @SerialName("version_groups") val versionGroups: List<NamedAPIResourceDto>
)

@Serializable
data class PokemonEntryDto(
    @SerialName("entry_number") val entryNumber: Int,
    @SerialName("pokemon_species") val pokemonSpecies: NamedAPIResourceDto
)