package sz.sapphirex.pokedex.domain.model.base.pokemon.growthrates

import kotlinx.serialization.Serializable

@Serializable
data class GrowthRateExperienceLevel(
    val level: Int,
    val experience: Int
)