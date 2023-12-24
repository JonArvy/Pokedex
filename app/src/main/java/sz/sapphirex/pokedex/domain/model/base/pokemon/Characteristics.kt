package sz.sapphirex.pokedex.domain.model.base.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.Description
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class Characteristic(
    val id: Int,
    val geneModulo: Int,
    val possibleValues: List<Int>,
    val highestStat: NamedAPIResource,
    val descriptions: List<Description>
)
