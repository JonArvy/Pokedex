package sz.sapphirex.pokedex.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import sz.sapphirex.pokedex.data.api.ApiEndpoints.ENDPOINT_ABILITY
import sz.sapphirex.pokedex.data.api.ApiEndpoints.ENDPOINT_POKEMON
import sz.sapphirex.pokedex.data.api.ApiEndpoints.ENDPOINT_POKEMON_SPECIES
import kotlinx.serialization.json.Json
import sz.sapphirex.pokedex.domain.ApplicationLogger.Companion.apiLogger
import sz.sapphirex.pokedex.domain.model.ApiResult
import sz.sapphirex.pokedex.domain.model.base.pokemon.abilities.Ability
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.base.pokemon.pokemonspecies.PokemonSpecies
import sz.sapphirex.pokedex.domain.model.base.resource.Named

@Deprecated(
    message = "This class is deprecated, move to RawPokeApi",
    replaceWith = ReplaceWith("RawPokeApi"),
    level = DeprecationLevel.WARNING
)
class PokeApi {
    @Deprecated("This property is deprecated, move to RawPokeApi")
    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    /******************** GENERIC ENDPOINT ********************/
    @Deprecated("Move To RawPokeApi", ReplaceWith("RawPokeApi().getDataByEndpoint(endpoint)", "RawPokeApi"))
    suspend fun getDataByEndpoint(endpoint: String): ApiResult<Named> {
        return safeApiCall<Named>(endpoint)
    }

    /******************** POKEMON ********************/
    @Deprecated("Move To RawPokeApi")
    suspend fun getPokemon(id: Int): ApiResult<Pokemon> {
        return safeApiCall<Pokemon>("${ENDPOINT_POKEMON}$id/")
    }

    @Deprecated("Move To RawPokeApi")
    suspend fun getPokemon(name: String): ApiResult<Pokemon> {
        return safeApiCall<Pokemon>("${ENDPOINT_POKEMON}$name/")
    }

    @Deprecated("Move To RawPokeApi")
    suspend fun getPokemonAbility(id: Int): ApiResult<Ability> {
        return safeApiCall<Ability>("${ENDPOINT_ABILITY}$id/")
    }

    @Deprecated("Move To RawPokeApi")
    suspend fun getPokemonAbility(name: String): ApiResult<Ability> {
        return safeApiCall<Ability>("${ENDPOINT_ABILITY}$name/")
    }

    /******************** POKEMON SPECIES ********************/
    @Deprecated("Move To RawPokeApi")
    suspend fun getPokemonSpecies(id: Int): ApiResult<PokemonSpecies> {
        return safeApiCall<PokemonSpecies>("${ENDPOINT_POKEMON_SPECIES}$id/")
    }

    @Deprecated("Move To RawPokeApi")
    suspend fun getPokemonSpecies(name: String): ApiResult<PokemonSpecies> {
        return safeApiCall<PokemonSpecies>("${ENDPOINT_POKEMON_SPECIES}$name/")
    }

    /******************** HELPER ********************/
    // Api Caller Main Function
    @Deprecated("Move To RawPokeApi")
    private suspend inline fun <reified T: Any> safeApiCall(endpoint: String): ApiResult<T> {
        return try {
            val result = client.get(endpoint)
            ApiResult.Success(result.body() as T)
        } catch (e: Exception) {
            apiLogger(e.message)
            ApiResult.Error(e)
        }
    }
}