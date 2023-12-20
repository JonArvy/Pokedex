package sz.sapphirex.pokedex.domain.model.base.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

@Serializable
data class MoveBattleStylePreference(
    @SerialName("low_hp_preference") val lowHpPreference: Int,
    @SerialName("high_hp_preference") val highHpPreference: Int,
    @SerialName("move_battle_style") val moveBattleStyle: NamedAPIResource
)

@Serializable
data class Nature(
    val id: Int,
    val name: String,
    @SerialName("decreased_stat") val decreasedStat: NamedAPIResource,
    @SerialName("increased_stat") val increasedStat: NamedAPIResource,
    @SerialName("hates_flavor") val hatesFlavor: NamedAPIResource,
    @SerialName("likes_flavor") val likesFlavor: NamedAPIResource,
    @SerialName("pokeathlon_stat_changes") val pokeathlonStatChanges: List<NatureStatChange>,
    @SerialName("move_battle_style_preferences") val moveBattleStylePreferences: List<MoveBattleStylePreference>,
    val names: List<Name>
)

@Serializable
data class NatureStatChange(
    @SerialName("max_change") val maxChange: Int,
    @SerialName("pokeathlon_stat") val pokeathlonStat: NamedAPIResource
)