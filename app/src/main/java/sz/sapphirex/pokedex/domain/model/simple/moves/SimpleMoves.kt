package sz.sapphirex.pokedex.domain.model.simple.moves

import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class SimpleMove(
    val id: Int,
    val name: String,
    val type: NamedAPIResource?
)