package sz.sapphirex.pokedex.domain.model.simple.pokemon

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonSprites

@Serializable
@Entity(tableName = "pokemon")
data class SimplePokemon(
    @PrimaryKey val id: Int,
    val name: String,
    val sprites: PokemonSprites,
)