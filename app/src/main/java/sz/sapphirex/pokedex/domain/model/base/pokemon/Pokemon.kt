package sz.sapphirex.pokedex.domain.model.base.pokemon

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

@Serializable
@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey val id: Int,
    val name: String,
    @SerialName("base_experience") val baseExperience: Int,
    val height: Int,
    @SerialName("is_default") val isDefault: Boolean,
    val order: Int,
    val weight: Int,
    val abilities: List<PokemonAbility>,
    val forms: List<NamedAPIResource>,
    @SerialName("game_indices") val gameIndices: List<VersionGameIndex>,
    @SerialName("held_items") val heldItems: List<PokemonHeldItem>,
    @SerialName("location_area_encounters") val locationAreaEncounters: String,
    val moves: List<PokemonMove>,
    @SerialName("past_types") val pastTypes: List<PokemonTypePast>,
    val sprites: PokemonSprites,
    val species: NamedAPIResource,
    val stats: List<PokemonStat>,
    val types: List<PokemonType>,
)

@Serializable
data class PokemonAbility(
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int,
    val ability: NamedAPIResource,
)

@Serializable
data class PokemonFormType(
    val slot: Int,
    val type: NamedAPIResource
)

@Serializable
data class PokemonHeldItem(
    val item: NamedAPIResource,
    @SerialName("version_details") val versionDetails: List<PokemonHeldItemVersion>
)

@Serializable
data class PokemonHeldItemVersion(
    val version: NamedAPIResource,
    val rarity: Int,
)

@Serializable
data class PokemonMove(
    val move: NamedAPIResource,
    @SerialName("version_group_details") val versionGroupDetails: List<PokemonMoveVersion>,
)

@Serializable
data class PokemonMoveVersion(
    @SerialName("move_learn_method") val moveLearnMethod: NamedAPIResource,
    @SerialName("version_group") val versionGroup: NamedAPIResource,
    @SerialName("level_learned_at") val levelLearnedAt: Int,
)

@Serializable
data class PokemonSprites(
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
data class PokemonStat(
    val stat: NamedAPIResource,
    val effort: Int,
    @SerialName("base_stat") val baseStats: Int,
)

@Serializable
data class PokemonType(
    val slot: Int,
    val type: NamedAPIResource
)

@Serializable
data class PokemonTypePast(
    val generation: NamedAPIResource,
    val types: List<PokemonType>
)

@Serializable
data class VersionGameIndex(
    @SerialName("game_index") val gameIndex: Int,
    val version: NamedAPIResource
)