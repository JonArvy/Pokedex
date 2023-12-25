package sz.sapphirex.pokedex.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import sz.sapphirex.pokedex.core.logger.HtmlLogger
import sz.sapphirex.pokedex.core.logger.Logger
import sz.sapphirex.pokedex.core.logger.PokedexLogger
import sz.sapphirex.pokedex.data.local.Converters
import sz.sapphirex.pokedex.data.local.PokemonDao
import sz.sapphirex.pokedex.data.local.PokemonDatabase
import sz.sapphirex.pokedex.data.local.util.GsonParser
import sz.sapphirex.pokedex.data.remote.PokeApi
import sz.sapphirex.pokedex.data.remote.ktorHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokedexAppModule {
    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return ktorHttpClient
    }

    @Provides
    @Singleton
    fun providePokeApi(httpClient: HttpClient): PokeApi {
        return PokeApi(httpClient)
    }

    @Provides
    @Singleton
    fun providePokemonDatabase(@ApplicationContext context: Context): PokemonDatabase {
        return Room.databaseBuilder(context, PokemonDatabase::class.java, "app_database")
            .addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonDao(pokemonDatabase: PokemonDatabase): PokemonDao {
        return pokemonDatabase.pokemonDao()
    }

    @Provides
    @Singleton
    fun provideHtmlLogger(@ApplicationContext context: Context): HtmlLogger {
        return HtmlLogger(context)
    }

    @Provides
    @Singleton
    fun provideLogger(htmlLogger: HtmlLogger): Logger {
        return PokedexLogger(htmlLogger)
    }
}