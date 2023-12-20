package sz.sapphirex.pokedex.domain.model.base.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.Effect
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource
import sz.sapphirex.pokedex.domain.model.base.utility.VerboseEffect

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

@Serializable
data class AbilityEffectChange(
    @SerialName("effect_entries") val effectEntries: List<Effect>,
    @SerialName("version_group") val versionGroup: NamedAPIResource
)

@Serializable
data class AbilityFlavorText(
    @SerialName("flavor_text") val flavorText: String,
    val language: NamedAPIResource,
    @SerialName("version_group") val versionGroup: NamedAPIResource
)

@Serializable
data class AbilityPokemon(
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int,
    val pokemon: NamedAPIResource
)