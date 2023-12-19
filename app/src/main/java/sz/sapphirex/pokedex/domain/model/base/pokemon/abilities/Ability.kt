package sz.sapphirex.pokedex.domain.model.base.pokemon.abilities

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Name
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.VerboseEffect
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    val id: Int,
    val name: String,
    @SerialName("is_main_series") val isMainSeries: Boolean,
    val generation: NamedAPIResource,
    val names: List<Name>,
    @SerialName("effect_entries") val effectEntries: List<VerboseEffect>,
    @SerialName("effect_changes") val effectChanges: List<AbilityEffectChange>,
    @SerialName("flavor_text_entries") val flavorTextEntries: List<AbilityFlavorText>,
    val pokemon: List<AbilityPokemon>
)
