package sz.sapphirex.pokedex.domain.model.base.games

import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class Generation(
    val id: Int,
    val name: String,
    val abilities: List<NamedAPIResource>,
    val names: List<Name>,
    val mainRegion: NamedAPIResource,
    val moves: List<NamedAPIResource>,
    val pokemonSpecies: List<NamedAPIResource>,
    val types: List<NamedAPIResource>,
    val versionGroups: List<NamedAPIResource>
)