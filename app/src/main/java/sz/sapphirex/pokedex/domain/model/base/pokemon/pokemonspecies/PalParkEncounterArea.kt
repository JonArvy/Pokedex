package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemonspecies

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PalParkEncounterArea(
    @SerialName("base_score") val baseScore: Int,
    val rate: Int,
    val area: NamedAPIResource
)