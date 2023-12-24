package sz.sapphirex.pokedex.domain.model.base.games

import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class VersionGroup(
    val id: Int,
    val name: String,
    val order: Int,
    val generation: NamedAPIResource,
    val moveLearnMethods: List<NamedAPIResource>,
    val pokedexes: List<NamedAPIResource>,
    val regions: List<NamedAPIResource>,
    val versions: List<NamedAPIResource>
)