package sz.sapphirex.pokedex.data.local.entity.pokemon

import androidx.room.Entity
import androidx.room.PrimaryKey
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity
import sz.sapphirex.pokedex.data.local.entity.utility.VersionGameIndexEntity
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonAbility
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonFormType
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonHeldItem
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonHeldItemVersion
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonMove
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonMoveVersion
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonSprites
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonStat
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonType
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonTypePast

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val baseExperience: Int,
    val height: Int,
    val isDefault: Boolean,
    val order: Int,
    val weight: Int,
    val abilities: List<PokemonAbilityEntity>,
    val forms: List<NamedAPIResourceEntity>,
    val gameIndices: List<VersionGameIndexEntity>,
    val heldItems: List<PokemonHeldItemEntity>,
    val locationAreaEncounters: String,
    val moves: List<PokemonMoveEntity>,
    val pastTypes: List<PokemonTypePastEntity>,
    val sprites: PokemonSpritesEntity,
    val species: NamedAPIResourceEntity,
    val stats: List<PokemonStatEntity>,
    val types: List<PokemonTypeEntity>,
) {
    fun toBase(): Pokemon {
        return Pokemon(
            id = id,
            name = name,
            baseExperience = baseExperience,
            height = height,
            isDefault = isDefault,
            order =  order,
            weight = weight,
            abilities = abilities.map { it.toBase() },
            forms = forms.map { it.toBase() },
            gameIndices = gameIndices.map { it.toBase() },
            heldItems = heldItems.map { it.toBase() },
            locationAreaEncounters = locationAreaEncounters,
            moves = moves.map { it.toBase() },
            pastTypes = pastTypes.map { it.toBase() },
            sprites = sprites.toBase(),
            species = species.toBase(),
            stats = stats.map { it.toBase() },
            types = types.map { it.toBase() }
        )
    }
}

data class PokemonAbilityEntity(
    val isHidden: Boolean,
    val slot: Int,
    val ability: NamedAPIResourceEntity,
) {
    fun toBase(): PokemonAbility {
        return PokemonAbility(
            isHidden = isHidden,
            slot = slot,
            ability = ability.toBase()
        )
    }
}

data class PokemonFormTypeEntity(
    val slot: Int,
    val type: NamedAPIResourceEntity
) {
    fun toBase(): PokemonFormType {
        return PokemonFormType(
            slot = slot,
            type = type.toBase()
        )
    }
}

data class PokemonHeldItemEntity(
    val item: NamedAPIResourceEntity,
    val versionDetails: List<PokemonHeldItemVersionEntity>
) {
    fun toBase(): PokemonHeldItem {
        return PokemonHeldItem(
            item = item.toBase(),
            versionDetails = versionDetails.map { it.toBase() }
        )
    }
}

data class PokemonHeldItemVersionEntity(
    val version: NamedAPIResourceEntity,
    val rarity: Int,
) {
    fun toBase(): PokemonHeldItemVersion {
        return PokemonHeldItemVersion(
            version = version.toBase(),
            rarity = rarity
        )
    }
}

data class PokemonMoveEntity(
    val move: NamedAPIResourceEntity,
    val versionGroupDetails: List<PokemonMoveVersionEntity>,
) {
    fun toBase(): PokemonMove {
        return PokemonMove(
            move = move.toBase(),
            versionGroupDetails = versionGroupDetails.map { it.toBase() }
        )
    }
}

data class PokemonMoveVersionEntity(
    val moveLearnMethod: NamedAPIResourceEntity,
    val versionGroup: NamedAPIResourceEntity,
    val levelLearnedAt: Int,
) {
    fun toBase(): PokemonMoveVersion {
        return PokemonMoveVersion(
            moveLearnMethod = moveLearnMethod.toBase(),
            versionGroup = versionGroup.toBase(),
            levelLearnedAt = levelLearnedAt
        )
    }
}

data class PokemonSpritesEntity(
    val backDefault: String?,
    val backFemale: String?,
    val backShiny: String?,
    val backShinyFemale: String?,
    val frontDefault: String?,
    val frontFemale: String?,
    val frontShiny: String?,
    val frontShinyFemale: String?,
) {
    fun toBase(): PokemonSprites {
        return PokemonSprites(
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

data class PokemonStatEntity(
    val stat: NamedAPIResourceEntity,
    val effort: Int,
    val baseStats: Int,
) {
    fun toBase(): PokemonStat {
        return PokemonStat(
            stat = stat.toBase(),
            effort = effort,
            baseStats = baseStats
        )
    }
}

data class PokemonTypeEntity(
    val slot: Int,
    val type: NamedAPIResourceEntity
) {
    fun toBase(): PokemonType {
        return PokemonType(
            slot = slot,
            type = type.toBase()
        )
    }
}

data class PokemonTypePastEntity(
    val generation: NamedAPIResourceEntity,
    val types: List<PokemonTypeEntity>
) {
    fun toBase(): PokemonTypePast {
        return PokemonTypePast(
            generation = generation.toBase(),
            types = types.map { it.toBase() }
        )
    }
}