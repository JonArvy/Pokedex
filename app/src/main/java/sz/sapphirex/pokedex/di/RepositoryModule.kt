package sz.sapphirex.pokedex.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sz.sapphirex.pokedex.core.logger.Logger
import sz.sapphirex.pokedex.data.local.PokemonDao
import sz.sapphirex.pokedex.data.remote.PokeApi
import sz.sapphirex.pokedex.data.repository.PokemonListRepositoryImpl
import sz.sapphirex.pokedex.data.repository.PokemonRepositoryImpl
import sz.sapphirex.pokedex.domain.repository.PokemonListRepository
import sz.sapphirex.pokedex.domain.repository.PokemonRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providePokedexRepository(api: PokeApi, pokemonDao: PokemonDao, logger: Logger): PokemonListRepository {
        return PokemonListRepositoryImpl(api, pokemonDao, logger)
    }

    @Provides
    @Singleton
    fun providePokemonRepository(api: PokeApi, pokemonDao: PokemonDao): PokemonRepository {
        return PokemonRepositoryImpl(api, pokemonDao)
    }
}