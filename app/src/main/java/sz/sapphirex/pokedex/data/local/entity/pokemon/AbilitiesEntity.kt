package sz.sapphirex.pokedex.data.local.entity.pokemon

import sz.sapphirex.pokedex.data.local.entity.utility.EffectEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity
import sz.sapphirex.pokedex.data.local.entity.utility.VerboseEffectEntity

data class AbilityEntity(
    val id: Int,
    val name: String,
    val isMainSeries: Boolean,
    val generation: NamedAPIResourceEntity,
    val names: List<NameEntity>,
    val effectEntries: List<VerboseEffectEntity>,
    val effectChanges: List<AbilityEffectChangeEntity>,
    val flavorTextEntries: List<AbilityFlavorTextEntity>,
    val pokemon: List<AbilityPokemonEntity>
)

data class AbilityEffectChangeEntity(
    val effectEntries: List<EffectEntity>,
    val versionGroup: NamedAPIResourceEntity
)

data class AbilityFlavorTextEntity(
    val flavorText: String,
    val language: NamedAPIResourceEntity,
    val versionGroup: NamedAPIResourceEntity
)

data class AbilityPokemonEntity(
    val isHidden: Boolean,
    val slot: Int,
    val pokemon: NamedAPIResourceEntity
)
