package kek.dex.pokedex.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import sz.sapphirex.pokedex.data.api.ApiEndpoints
import sz.sapphirex.pokedex.domain.model.base.pokemon.Ability
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonSpecies
import sz.sapphirex.pokedex.domain.model.base.resource.Named

class PokeApi {
    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    /******************** GENERIC ENDPOINT ********************/
    suspend fun getDataByEndpoint(endpoint: String): Named {
        return safeApiCall<Named>(endpoint)
    }

    /******************** POKEMON ********************/
    suspend fun getPokemon(id: Int): Pokemon {
        return safeApiCall<Pokemon>("${ApiEndpoints.ENDPOINT_POKEMON}$id/")
    }

    suspend fun getPokemon(name: String): Pokemon {
        return safeApiCall<Pokemon>("${ApiEndpoints.ENDPOINT_POKEMON}$name/")
    }

    suspend fun getPokemonAbility(id: Int): Ability {
        return safeApiCall<Ability>("${ApiEndpoints.ENDPOINT_ABILITY}$id/")
    }

    suspend fun getPokemonAbility(name: String): Ability {
        return safeApiCall<Ability>("${ApiEndpoints.ENDPOINT_ABILITY}$name/")
    }

    /******************** POKEMON SPECIES ********************/
    suspend fun getPokemonSpecies(id: Int): PokemonSpecies {
        return safeApiCall<PokemonSpecies>("${ApiEndpoints.ENDPOINT_POKEMON_SPECIES}$id/")
    }

    suspend fun getPokemonSpecies(name: String): PokemonSpecies {
        return safeApiCall<PokemonSpecies>("${ApiEndpoints.ENDPOINT_POKEMON_SPECIES}$name/")
    }

    /******************** HELPER ********************/
    // Api Caller Main Function
    private suspend inline fun <reified T : Any> safeApiCall(endpoint: String): T {
        val result = client.get(endpoint)
        return result.body<T>()
    }
}