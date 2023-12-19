package sz.sapphirex.pokedex.domain.model.base.games.pokedexes

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Description
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Name
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokedex(
    val id: Int,
    val name: String,
    @SerialName("is_main_series") val isMainSeries: Boolean,
    val descriptions: List<Description>,
    val names: List<Name>,
    @SerialName("pokemon_entries") val pokemonEntries: List<PokemonEntry>,
    val region: NamedAPIResource,
    @SerialName("version_groups") val versionGroups: List<NamedAPIResource>
)