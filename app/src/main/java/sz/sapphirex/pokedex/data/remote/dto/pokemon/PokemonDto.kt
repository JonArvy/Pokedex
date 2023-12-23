package sz.sapphirex.pokedex.data.remote.dto.pokemon

import androidx.room.Entity
import androidx.room.PrimaryKey
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
import sz.sapphirex.pokedex.domain.model.base.pokemon.VersionGameIndex

@Serializable
@Entity(tableName = "pokemon")
data class PokemonDto(
    @PrimaryKey val id: Int,
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
    fun toPokemon(): Pokemon {
        return Pokemon(
            id = id,
            name = name,
            baseExperience = baseExperience,
            height = height,
            isDefault = isDefault,
            order = order,
            weight = weight,
            abilities = abilities.map { it.toAbility() },
            forms = forms.map { it.toNamedAPIResource() },
            gameIndices = gameIndices.map { it.toVersionGameIndex() },
            heldItems = heldItems.map { it.toPokemonHeldItem() },
            locationAreaEncounters = locationAreaEncounters,
            moves = moves.map { it.toPokemonMove() },
            pastTypes = pastTypes.map { it.toPokemonTypePast() },
            sprites = sprites.toPokemonSprites(),
            species = species.toNamedAPIResource(),
            stats = stats.map { it.toPokemonStat() },
            types = types.map { it.toPokemonType() }
        )
    }
}

@Serializable
data class PokemonAbilityDto(
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int,
    val ability: NamedAPIResourceDto,
) {
    fun toAbility(): PokemonAbility {
        return PokemonAbility(
            isHidden = isHidden,
            slot = slot,
            ability = ability.toNamedAPIResource()
        )
    }
}

@Serializable
data class PokemonFormTypeDto(
    val slot: Int,
    val type: NamedAPIResourceDto
) {
    fun toPokemonFormType(): PokemonFormType {
        return PokemonFormType(
            slot = slot,
            type = type.toNamedAPIResource()
        )
    }
}

@Serializable
data class PokemonHeldItemDto(
    val item: NamedAPIResourceDto,
    @SerialName("version_details") val versionDetails: List<PokemonHeldItemVersionDto>
) {
    fun toPokemonHeldItem(): PokemonHeldItem {
        return PokemonHeldItem(
            item = item.toNamedAPIResource(),
            versionDetails = versionDetails.map { it.toPokemonHeldItemVersion() }
        )
    }
}

@Serializable
data class PokemonHeldItemVersionDto(
    val version: NamedAPIResourceDto,
    val rarity: Int,
) {
    fun toPokemonHeldItemVersion(): PokemonHeldItemVersion {
        return PokemonHeldItemVersion(
            version = version.toNamedAPIResource(),
            rarity = rarity
        )
    }
}

@Serializable
data class PokemonMoveDto(
    val move: NamedAPIResourceDto,
    @SerialName("version_group_details") val versionGroupDetails: List<PokemonMoveVersionDto>,
) {
    fun toPokemonMove(): PokemonMove {
        return PokemonMove(
            move = move.toNamedAPIResource(),
            versionGroupDetails = versionGroupDetails.map { it.toPokemonMoveVersion() }
        )
    }
}

@Serializable
data class PokemonMoveVersionDto(
    @SerialName("move_learn_method") val moveLearnMethod: NamedAPIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto,
    @SerialName("level_learned_at") val levelLearnedAt: Int,
) {
    fun toPokemonMoveVersion(): PokemonMoveVersion {
        return PokemonMoveVersion(
            moveLearnMethod = moveLearnMethod.toNamedAPIResource(),
            versionGroup = versionGroup.toNamedAPIResource(),
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
    fun toPokemonSprites(): PokemonSprites {
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
    fun toPokemonStat(): PokemonStat {
        return PokemonStat(
            stat = stat.toNamedAPIResource(),
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
    fun toPokemonType(): PokemonType {
        return PokemonType(
            slot = slot,
            type = type.toNamedAPIResource()
        )
    }
}

@Serializable
data class PokemonTypePastDto(
    val generation: NamedAPIResourceDto,
    val types: List<PokemonTypeDto>
) {
    fun toPokemonTypePast(): PokemonTypePast {
        return PokemonTypePast(
            generation = generation.toNamedAPIResource(),
            types = types.map { it.toPokemonType() }
        )
    }
}

@Serializable
data class VersionGameIndexDto(
    @SerialName("game_index") val gameIndex: Int,
    val version: NamedAPIResourceDto
) {
    fun toVersionGameIndex(): VersionGameIndex {
        return VersionGameIndex(
            gameIndex = gameIndex,
            version = version.toNamedAPIResource()
        )
    }
}