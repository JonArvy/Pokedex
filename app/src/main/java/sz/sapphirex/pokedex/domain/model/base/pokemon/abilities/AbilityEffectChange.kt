package sz.sapphirex.pokedex.domain.model.base.pokemon.abilities

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Effect
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityEffectChange(
    @SerialName("effect_entries") val effectEntries: List<Effect>,
    @SerialName("version_group") val versionGroup: NamedAPIResource
)