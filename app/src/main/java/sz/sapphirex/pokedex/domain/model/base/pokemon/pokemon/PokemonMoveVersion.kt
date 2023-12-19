package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonMoveVersion(
    @SerialName("move_learn_method") val moveLearnMethod: NamedAPIResource,
    @SerialName("version_group") val versionGroup: NamedAPIResource,
    @SerialName("level_learned_at") val levelLearnedAt: Int,
)