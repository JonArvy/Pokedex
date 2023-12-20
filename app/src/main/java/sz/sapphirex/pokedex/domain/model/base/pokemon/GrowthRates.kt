package sz.sapphirex.pokedex.domain.model.base.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.Description
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

@Serializable
data class GrowthRate(
    val id: Int,
    val name: String,
    val formula: String,
    val descriptions: List<Description>,
    val levels: List<GrowthRateExperienceLevel>,
    @SerialName("pokemon_species")
    val pokemonSpecies: List<NamedAPIResource>
)

@Serializable
data class GrowthRateExperienceLevel(
    val level: Int,
    val experience: Int
)