package sz.sapphirex.pokedex.domain.model.base.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.Effect
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource
import sz.sapphirex.pokedex.domain.model.base.utility.VerboseEffect

data class Ability(
    val id: Int,
    val name: String,
    val isMainSeries: Boolean,
    val generation: NamedAPIResource,
    val names: List<Name>,
    val effectEntries: List<VerboseEffect>,
    val effectChanges: List<AbilityEffectChange>,
    val flavorTextEntries: List<AbilityFlavorText>,
    val pokemon: List<AbilityPokemon>
)

data class AbilityEffectChange(
    val effectEntries: List<Effect>,
    val versionGroup: NamedAPIResource
)

data class AbilityFlavorText(
    val flavorText: String,
    val language: NamedAPIResource,
    val versionGroup: NamedAPIResource
)

data class AbilityPokemon(
    val isHidden: Boolean,
    val slot: Int,
    val pokemon: NamedAPIResource
)