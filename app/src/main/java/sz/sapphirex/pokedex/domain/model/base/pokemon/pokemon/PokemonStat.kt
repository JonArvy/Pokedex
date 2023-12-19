package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonStat(
    val stat: NamedAPIResource,
    val effort: Int,
    @SerialName("base_stat") val baseStats: Int,
)