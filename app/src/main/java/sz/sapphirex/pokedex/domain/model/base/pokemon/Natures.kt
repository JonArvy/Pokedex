package sz.sapphirex.pokedex.domain.model.base.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class MoveBattleStylePreference(
    val lowHpPreference: Int,
    val highHpPreference: Int,
    val moveBattleStyle: NamedAPIResource
)

data class Nature(
    val id: Int,
    val name: String,
    val decreasedStat: NamedAPIResource,
    val increasedStat: NamedAPIResource,
    val hatesFlavor: NamedAPIResource,
    val likesFlavor: NamedAPIResource,
    val pokeathlonStatChanges: List<NatureStatChange>,
    val moveBattleStylePreferences: List<MoveBattleStylePreference>,
    val names: List<Name>
)

data class NatureStatChange(
    val maxChange: Int,
    val pokeathlonStat: NamedAPIResource
)