package sz.sapphirex.pokedex.domain.model.base.pokemon

import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonAbilityEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonFormTypeEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonHeldItemEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonHeldItemVersionEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonMoveEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonMoveVersionEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonSpritesEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonStatEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonTypeEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonTypePastEntity
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource
import sz.sapphirex.pokedex.domain.model.base.utility.VersionGameIndex

data class Pokemon(
    val id: Int,
    val name: String,
    val baseExperience: Int,
    val height: Int,
    val isDefault: Boolean,
    val order: Int,
    val weight: Int,
    val abilities: List<PokemonAbility>,
    val forms: List<NamedAPIResource>,
    val gameIndices: List<VersionGameIndex>,
    val heldItems: List<PokemonHeldItem>,
    val locationAreaEncounters: String,
    val moves: List<PokemonMove>,
    val pastTypes: List<PokemonTypePast>,
    val sprites: PokemonSprites,
    val species: NamedAPIResource,
    val stats: List<PokemonStat>,
    val types: List<PokemonType>,
) {
    fun toEntity(): PokemonEntity {
        return PokemonEntity(
            id = id,
            name = name,
            baseExperience = baseExperience,
            height = height,
            isDefault = isDefault,
            order = order,
            weight = weight,
            abilities = abilities.map { it.toEntity() },
            forms = forms.map { it.toEntity() },
            gameIndices = gameIndices.map { it.toEntity() },
            heldItems = heldItems.map { it.toEntity() },
            locationAreaEncounters = locationAreaEncounters,
            moves = moves.map { it.toEntity() },
            pastTypes = pastTypes.map { it.toEntity() },
            sprites = sprites.toEntity(),
            species = species.toEntity(),
            stats = stats.map { it.toEntity() },
            types = types.map { it.toEntity() }
        )
    }
}

data class PokemonAbility(
    val isHidden: Boolean,
    val slot: Int,
    val ability: NamedAPIResource,
) {
    fun toEntity(): PokemonAbilityEntity {
        return PokemonAbilityEntity(
            isHidden = isHidden,
            slot = slot,
            ability = ability.toEntity()
        )
    }
}

data class PokemonFormType(
    val slot: Int,
    val type: NamedAPIResource
) {
    fun toEntity(): PokemonFormTypeEntity {
        return PokemonFormTypeEntity(
            slot = slot,
            type = type.toEntity()
        )
    }
}

data class PokemonHeldItem(
    val item: NamedAPIResource,
    val versionDetails: List<PokemonHeldItemVersion>
) {
    fun toEntity(): PokemonHeldItemEntity {
        return PokemonHeldItemEntity(
            item = item.toEntity(),
            versionDetails = versionDetails.map { it.toEntity() }
        )
    }
}

data class PokemonHeldItemVersion(
    val version: NamedAPIResource,
    val rarity: Int,
) {
    fun toEntity(): PokemonHeldItemVersionEntity {
        return PokemonHeldItemVersionEntity(
            version = version.toEntity(),
            rarity = rarity
        )
    }
}

data class PokemonMove(
    val move: NamedAPIResource,
    val versionGroupDetails: List<PokemonMoveVersion>,
) {
    fun toEntity(): PokemonMoveEntity {
        return PokemonMoveEntity(
            move = move.toEntity(),
            versionGroupDetails = versionGroupDetails.map { it.toEntity() }
        )
    }
}

data class PokemonMoveVersion(
    val moveLearnMethod: NamedAPIResource,
    val versionGroup: NamedAPIResource,
    val levelLearnedAt: Int,
) {
    fun toEntity(): PokemonMoveVersionEntity {
        return PokemonMoveVersionEntity(
            moveLearnMethod = moveLearnMethod.toEntity(),
            versionGroup = versionGroup.toEntity(),
            levelLearnedAt = levelLearnedAt
        )
    }
}

data class PokemonSprites(
    val backDefault: String?,
    val backFemale: String?,
    val backShiny: String?,
    val backShinyFemale: String?,
    val frontDefault: String?,
    val frontFemale: String?,
    val frontShiny: String?,
    val frontShinyFemale: String?,
) {
    fun toEntity(): PokemonSpritesEntity {
        return PokemonSpritesEntity(
            backDefault = backDefault,
            backFemale = backFemale,
            backShiny = backShiny,
            backShinyFemale = backShinyFemale,
            frontDefault = frontDefault,
            frontFemale = frontFemale,
            frontShiny = frontShiny,
            frontShinyFemale = frontShinyFemale
        )
    }
}

data class PokemonStat(
    val stat: NamedAPIResource,
    val effort: Int,
    val baseStats: Int,
) {
    fun toEntity(): PokemonStatEntity {
        return PokemonStatEntity(
            stat = stat.toEntity(),
            effort = effort,
            baseStats = baseStats
        )
    }
}

data class PokemonType(
    val slot: Int,
    val type: NamedAPIResource
) {
    fun toEntity(): PokemonTypeEntity {
        return PokemonTypeEntity(
            slot = slot,
            type = type.toEntity()
        )
    }
}

data class PokemonTypePast(
    val generation: NamedAPIResource,
    val types: List<PokemonType>
) {
    fun toEntity(): PokemonTypePastEntity {
        return PokemonTypePastEntity(
            generation = generation.toEntity(),
            types = types.map { it.toEntity() }
        )
    }
}