package sz.sapphirex.pokedex.domain.model.base.games

import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class Version(
    val id: Int,
    val name: String,
    val names: List<Name>,
    val versionGroup: NamedAPIResource
)
