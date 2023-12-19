package sz.sapphirex.pokedex.domain.model.base.pokemon.natures

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoveBattleStylePreference(
    @SerialName("low_hp_preference") val lowHpPreference: Int,
    @SerialName("high_hp_preference") val highHpPreference: Int,
    @SerialName("move_battle_style") val moveBattleStyle: NamedAPIResource
)