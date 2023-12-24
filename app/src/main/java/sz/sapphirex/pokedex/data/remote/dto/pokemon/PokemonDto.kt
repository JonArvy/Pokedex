package sz.sapphirex.pokedex.data.remote.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto
import sz.sapphirex.pokedex.data.remote.dto.utility.VersionGameIndexDto
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

@Serializable
data class PokemonDto(
    val id: Int,
    val name: String,
    @SerialName("base_experience") val baseExperience: Int,
    val height: Int,
    @SerialName("is_default") val isDefault: Boolean,
    val order: Int,
    val weight: Int,
    val abilities: List<PokemonAbilityDto>,
    val forms: List<NamedAPIResourceDto>,
    @SerialName("game_indices") val gameIndices: List<VersionGameIndexDto>,
    @SerialName("held_items") val heldItems: List<PokemonHeldItemDto>,
    @SerialName("location_area_encounters") val locationAreaEncounters: String,
    val moves: List<PokemonMoveDto>,
    @SerialName("past_types") val pastTypes: List<PokemonTypePastDto>,
    val sprites: PokemonSpritesDto,
    val species: NamedAPIResourceDto,
    val stats: List<PokemonStatDto>,
    val types: List<PokemonTypeDto>,
) {
    fun toBase(): Pokemon {
        return Pokemon(
            id = id,
            name = name,
            baseExperience = baseExperience,
            height = height,
            isDefault = isDefault,
            order = order,
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

@Serializable
data class PokemonAbilityDto(
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int,
    val ability: NamedAPIResourceDto,
) {
    fun toBase(): PokemonAbility {
        return PokemonAbility(
            isHidden = isHidden,
            slot = slot,
            ability = ability.toBase()
        )
    }
}

@Serializable
data class PokemonFormTypeDto(
    val slot: Int,
    val type: NamedAPIResourceDto
) {
    fun toBase(): PokemonFormType {
        return PokemonFormType(
            slot = slot,
            type = type.toBase()
        )
    }
}

@Serializable
data class PokemonHeldItemDto(
    val item: NamedAPIResourceDto,
    @SerialName("version_details") val versionDetails: List<PokemonHeldItemVersionDto>
) {
    fun toBase(): PokemonHeldItem {
        return PokemonHeldItem(
            item = item.toBase(),
            versionDetails = versionDetails.map { it.toBase() }
        )
    }
}

@Serializable
data class PokemonHeldItemVersionDto(
    val version: NamedAPIResourceDto,
    val rarity: Int,
) {
    fun toBase(): PokemonHeldItemVersion {
        return PokemonHeldItemVersion(
            version = version.toBase(),
            rarity = rarity
        )
    }
}

@Serializable
data class PokemonMoveDto(
    val move: NamedAPIResourceDto,
    @SerialName("version_group_details") val versionGroupDetails: List<PokemonMoveVersionDto>,
) {
    fun toBase(): PokemonMove {
        return PokemonMove(
            move = move.toBase(),
            versionGroupDetails = versionGroupDetails.map { it.toBase() }
        )
    }
}

@Serializable
data class PokemonMoveVersionDto(
    @SerialName("move_learn_method") val moveLearnMethod: NamedAPIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto,
    @SerialName("level_learned_at") val levelLearnedAt: Int,
) {
    fun toBase(): PokemonMoveVersion {
        return PokemonMoveVersion(
            moveLearnMethod = moveLearnMethod.toBase(),
            versionGroup = versionGroup.toBase(),
            levelLearnedAt = levelLearnedAt
        )
    }
}

@Serializable
data class PokemonSpritesDto(
    @SerialName("back_default") val backDefault: String?,
    @SerialName("back_female") val backFemale: String?,
    @SerialName("back_shiny") val backShiny: String?,
    @SerialName("back_shiny_female") val backShinyFemale: String?,
    @SerialName("front_default") val frontDefault: String?,
    @SerialName("front_female") val frontFemale: String?,
    @SerialName("front_shiny") val frontShiny: String?,
    @SerialName("front_shiny_female") val frontShinyFemale: String?,
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

@Serializable
data class PokemonStatDto(
    val stat: NamedAPIResourceDto,
    val effort: Int,
    @SerialName("base_stat") val baseStats: Int,
) {
    fun toBase(): PokemonStat {
        return PokemonStat(
            stat = stat.toBase(),
            effort = effort,
            baseStats = baseStats
        )
    }
}

@Serializable
data class PokemonTypeDto(
    val slot: Int,
    val type: NamedAPIResourceDto
) {
    fun toBase(): PokemonType {
        return PokemonType(
            slot = slot,
            type = type.toBase()
        )
    }
}

@Serializable
data class PokemonTypePastDto(
    val generation: NamedAPIResourceDto,
    val types: List<PokemonTypeDto>
) {
    fun toBase(): PokemonTypePast {
        return PokemonTypePast(
            generation = generation.toBase(),
            types = types.map { it.toBase() }
        )
    }
}