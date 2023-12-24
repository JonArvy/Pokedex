package sz.sapphirex.pokedex.data.local.entity.pokemon

import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class MoveBattleStylePreferenceEntity(
    val lowHpPreference: Int,
    val highHpPreference: Int,
    val moveBattleStyle: NamedAPIResourceEntity
)

data class NatureEntity(
    val id: Int,
    val name: String,
    val decreasedStat: NamedAPIResourceEntity,
    val increasedStat: NamedAPIResourceEntity,
    val hatesFlavor: NamedAPIResourceEntity,
    val likesFlavor: NamedAPIResourceEntity,
    val pokeathlonStatChanges: List<NatureStatChangeEntity>,
    val moveBattleStylePreferences: List<MoveBattleStylePreferenceEntity>,
    val names: List<NameEntity>
)

data class NatureStatChangeEntity(
    val maxChange: Int,
    val pokeathlonStat: NamedAPIResourceEntity
)
