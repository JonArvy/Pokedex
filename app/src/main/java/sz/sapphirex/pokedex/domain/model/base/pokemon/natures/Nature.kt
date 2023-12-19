package sz.sapphirex.pokedex.domain.model.base.pokemon.natures

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Name
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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