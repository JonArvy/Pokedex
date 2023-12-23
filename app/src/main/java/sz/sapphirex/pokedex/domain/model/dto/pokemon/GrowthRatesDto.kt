package sz.sapphirex.pokedex.domain.model.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.dto.utility.DescriptionDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NamedAPIResourceDto

@Serializable
data class GrowthRateDtoDto(
    val id: Int,
    val name: String,
    val formula: String,
    val descriptions: List<DescriptionDto>,
    val levels: List<GrowthRateExperienceLevelDto>,
    @SerialName("pokemon_species")
    val pokemonSpecies: List<NamedAPIResourceDto>
)

@Serializable
data class GrowthRateExperienceLevelDto(
    val level: Int,
    val experience: Int
)