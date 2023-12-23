package sz.sapphirex.pokedex.data.remote.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.remote.dto.utility.NameDto
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto

@Serializable
data class MoveBattleStylePreferenceDto(
    @SerialName("low_hp_preference") val lowHpPreference: Int,
    @SerialName("high_hp_preference") val highHpPreference: Int,
    @SerialName("move_battle_style") val moveBattleStyle: NamedAPIResourceDto
)

@Serializable
data class NatureDto(
    val id: Int,
    val name: String,
    @SerialName("decreased_stat") val decreasedStat: NamedAPIResourceDto,
    @SerialName("increased_stat") val increasedStat: NamedAPIResourceDto,
    @SerialName("hates_flavor") val hatesFlavor: NamedAPIResourceDto,
    @SerialName("likes_flavor") val likesFlavor: NamedAPIResourceDto,
    @SerialName("pokeathlon_stat_changes") val pokeathlonStatChanges: List<NatureStatChangeDto>,
    @SerialName("move_battle_style_preferences") val moveBattleStylePreferences: List<MoveBattleStylePreferenceDto>,
    val names: List<NameDto>
)

@Serializable
data class NatureStatChangeDto(
    @SerialName("max_change") val maxChange: Int,
    @SerialName("pokeathlon_stat") val pokeathlonStat: NamedAPIResourceDto
)