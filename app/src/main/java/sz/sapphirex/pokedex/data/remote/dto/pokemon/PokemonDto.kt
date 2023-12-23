package sz.sapphirex.pokedex.data.remote.dto.pokemon

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto
import sz.sapphirex.pokedex.data.remote.dto.utility.VersionGameIndexDto

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
)

@Serializable
data class PokemonAbilityDto(
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int,
    val ability: NamedAPIResourceDto,
)

@Serializable
data class PokemonFormTypeDto(
    val slot: Int,
    val type: NamedAPIResourceDto
)

@Serializable
data class PokemonHeldItemDto(
    val item: NamedAPIResourceDto,
    @SerialName("version_details") val versionDetails: List<PokemonHeldItemVersionDto>
)

@Serializable
data class PokemonHeldItemVersionDto(
    val version: NamedAPIResourceDto,
    val rarity: Int,
)

@Serializable
data class PokemonMoveDto(
    val move: NamedAPIResourceDto,
    @SerialName("version_group_details") val versionGroupDetails: List<PokemonMoveVersionDto>,
)

@Serializable
data class PokemonMoveVersionDto(
    @SerialName("move_learn_method") val moveLearnMethod: NamedAPIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto,
    @SerialName("level_learned_at") val levelLearnedAt: Int,
)

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
)

@Serializable
data class PokemonStatDto(
    val stat: NamedAPIResourceDto,
    val effort: Int,
    @SerialName("base_stat") val baseStats: Int,
)

@Serializable
data class PokemonTypeDto(
    val slot: Int,
    val type: NamedAPIResourceDto
)

@Serializable
data class PokemonTypePastDto(
    val generation: NamedAPIResourceDto,
    val types: List<PokemonTypeDto>
)

@Serializable
data class VersionGameIndexDto(
    @SerialName("game_index") val gameIndex: Int,
    val version: NamedAPIResourceDto
)