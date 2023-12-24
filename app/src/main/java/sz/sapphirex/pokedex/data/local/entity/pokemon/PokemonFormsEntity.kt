package sz.sapphirex.pokedex.data.local.entity.pokemon

import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class PokemonFormEntity(
    val id: Int,
    val name: String,
    val order: Int,
    val formOrder: Int,
    val isDefault: Boolean,
    val isBattleOnly: Boolean,
    val isMega: Boolean,
    val formName: String,
    val pokemon: NamedAPIResourceEntity,
    val types: List<PokemonFormTypeEntity>,
    val sprites: PokemonFormSpritesEntity,
    val versionGroup: NamedAPIResourceEntity,
    val names: List<NameEntity>,
    val formNames: List<NameEntity>
)

data class PokemonFormSpritesEntity(
    val frontDefault: String,
    val frontShiny: String,
    val backDefault: String,
    val backShiny: String
)
