package sz.sapphirex.pokedex.domain.model.base.pokemon.growthrates

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Description
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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