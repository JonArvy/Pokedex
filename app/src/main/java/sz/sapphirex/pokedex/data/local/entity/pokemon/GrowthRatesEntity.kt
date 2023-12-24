package sz.sapphirex.pokedex.data.local.entity.pokemon

import sz.sapphirex.pokedex.data.local.entity.utility.DescriptionEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class GrowthRateEntity(
    val id: Int,
    val name: String,
    val formula: String,
    val descriptions: List<DescriptionEntity>,
    val levels: List<GrowthRateExperienceLevelEntity>,
    val pokemonSpecies: List<NamedAPIResourceEntity>
)

data class GrowthRateExperienceLevelEntity(
    val level: Int,
    val experience: Int
)
