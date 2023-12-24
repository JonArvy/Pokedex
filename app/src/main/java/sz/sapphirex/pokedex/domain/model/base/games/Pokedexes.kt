package sz.sapphirex.pokedex.domain.model.base.games

import sz.sapphirex.pokedex.domain.model.base.utility.Description
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class Pokedex(
    val id: Int,
    val name: String,
    val isMainSeries: Boolean,
    val descriptions: List<Description>,
    val names: List<Name>,
    val pokemonEntries: List<PokemonEntry>,
    val region: NamedAPIResource,
    val versionGroups: List<NamedAPIResource>
)

data class PokemonEntry(
    val entryNumber: Int,
    val pokemonSpecies: NamedAPIResource
)