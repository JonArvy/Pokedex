package sz.sapphirex.pokedex.domain.model.base.pokemon.stats

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.APIResource
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Name
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stat(
    val id: Int,
    val name: String,
    @SerialName("game_index") val gameIndex: Int,
    @SerialName("is_battle_only") val isBattleOnly: Boolean,
    @SerialName("affecting_moves") val affectingMoves: MoveStatAffectSets,
    @SerialName("affecting_natures") val affectingNatures: NatureStatAffectSets,
    val characteristics: List<APIResource>,
    @SerialName("move_damage_class") val moveDamageClass: NamedAPIResource,
    val names: List<Name>
)