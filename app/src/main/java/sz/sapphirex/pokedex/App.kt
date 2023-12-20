package sz.sapphirex.pokedex

import android.app.Application
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp
import sz.sapphirex.pokedex.data.database.PokemonDao
import sz.sapphirex.pokedex.data.database.PokemonDatabase

@HiltAndroidApp
class App: Application() {
    private val database: PokemonDatabase by lazy {
        Room.databaseBuilder(this, PokemonDatabase::class.java, "app_database").build()
    }

    val pokemonDao: PokemonDao by lazy {
        database.pokemonDao()
    }

}