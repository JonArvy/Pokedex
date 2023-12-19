package sz.sapphirex.pokedex.domain.model.base.pokemon.natures

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NatureStatChange(
    @SerialName("max_change") val maxChange: Int,
    @SerialName("pokeathlon_stat") val pokeathlonStat: NamedAPIResource
)