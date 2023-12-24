package sz.sapphirex.pokedex.data.local.entity.pokemon

import sz.sapphirex.pokedex.data.local.entity.utility.DescriptionEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class CharacteristicEntity(
    val id: Int,
    val geneModulo: Int,
    val possibleValues: List<Int>,
    val highestStat: NamedAPIResourceEntity,
    val descriptions: List<DescriptionEntity>
)
