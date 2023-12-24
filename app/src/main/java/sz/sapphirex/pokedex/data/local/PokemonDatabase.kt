package sz.sapphirex.pokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonEntity
import sz.sapphirex.pokedex.data.local.entity.resource.NamedEntity

@Database(
    entities = [
        PokemonEntity::class,
        NamedEntity::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}