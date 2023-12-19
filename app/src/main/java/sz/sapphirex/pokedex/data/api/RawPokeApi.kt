package kek.dex.pokedex.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kek.dex.pokedex.domain.model.base.pokemon.abilities.Ability
import kek.dex.pokedex.domain.model.base.pokemon.pokemon.Pokemon
import kek.dex.pokedex.domain.model.base.pokemon.pokemonspecies.PokemonSpecies
import kek.dex.pokedex.domain.model.base.resource.Named
import kotlinx.serialization.json.Json
import sz.sapphirex.pokedex.data.api.ApiEndpoints

class RawPokeApi {
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
    suspend fun getPokemon(id: Int): kek.dex.pokedex.domain.model.base.pokemon.pokemon.Pokemon {
        return safeApiCall<kek.dex.pokedex.domain.model.base.pokemon.pokemon.Pokemon>("${ApiEndpoints.ENDPOINT_POKEMON}$id/")
    }

    suspend fun getPokemon(name: String): kek.dex.pokedex.domain.model.base.pokemon.pokemon.Pokemon {
        return safeApiCall<kek.dex.pokedex.domain.model.base.pokemon.pokemon.Pokemon>("${ApiEndpoints.ENDPOINT_POKEMON}$name/")
    }

    suspend fun getPokemonAbility(id: Int): kek.dex.pokedex.domain.model.base.pokemon.abilities.Ability {
        return safeApiCall<kek.dex.pokedex.domain.model.base.pokemon.abilities.Ability>("${ApiEndpoints.ENDPOINT_ABILITY}$id/")
    }

    suspend fun getPokemonAbility(name: String): kek.dex.pokedex.domain.model.base.pokemon.abilities.Ability {
        return safeApiCall<kek.dex.pokedex.domain.model.base.pokemon.abilities.Ability>("${ApiEndpoints.ENDPOINT_ABILITY}$name/")
    }

    /******************** POKEMON SPECIES ********************/
    suspend fun getPokemonSpecies(id: Int): kek.dex.pokedex.domain.model.base.pokemon.pokemonspecies.PokemonSpecies {
        return safeApiCall<kek.dex.pokedex.domain.model.base.pokemon.pokemonspecies.PokemonSpecies>("${ApiEndpoints.ENDPOINT_POKEMON_SPECIES}$id/")
    }

    suspend fun getPokemonSpecies(name: String): kek.dex.pokedex.domain.model.base.pokemon.pokemonspecies.PokemonSpecies {
        return safeApiCall<kek.dex.pokedex.domain.model.base.pokemon.pokemonspecies.PokemonSpecies>("${ApiEndpoints.ENDPOINT_POKEMON_SPECIES}$name/")
    }

    /******************** HELPER ********************/
    // Api Caller Main Function
    private suspend inline fun <reified T : Any> safeApiCall(endpoint: String): T {
        val result = client.get(endpoint)
        return result.body<T>()
    }
}