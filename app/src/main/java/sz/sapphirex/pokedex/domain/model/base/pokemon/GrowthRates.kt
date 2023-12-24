package sz.sapphirex.pokedex.domain.model.base.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.Description
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class GrowthRate(
    val id: Int,
    val name: String,
    val formula: String,
    val descriptions: List<Description>,
    val levels: List<GrowthRateExperienceLevel>,
    val pokemonSpecies: List<NamedAPIResource>
)

data class GrowthRateExperienceLevel(
    val level: Int,
    val experience: Int
)