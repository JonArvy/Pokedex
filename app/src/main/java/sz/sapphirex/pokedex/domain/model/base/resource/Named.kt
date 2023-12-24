package sz.sapphirex.pokedex.domain.model.base.resource

import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class Named(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<NamedAPIResource>
)