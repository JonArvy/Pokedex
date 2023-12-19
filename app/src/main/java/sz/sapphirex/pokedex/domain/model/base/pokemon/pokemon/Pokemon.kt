package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon

import androidx.room.Entity
import androidx.room.PrimaryKey
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
