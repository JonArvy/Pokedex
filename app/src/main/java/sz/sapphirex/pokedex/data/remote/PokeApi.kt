package sz.sapphirex.pokedex.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import sz.sapphirex.pokedex.data.remote.dto.pokemon.AbilityDto
import sz.sapphirex.pokedex.data.remote.dto.pokemon.PokemonDto
import sz.sapphirex.pokedex.data.remote.dto.pokemon.PokemonSpeciesDto
import sz.sapphirex.pokedex.data.remote.dto.resource.NamedDto
import javax.inject.Inject

class PokeApi @Inject constructor(
    private val httpClient: HttpClient
) {
    /******************** GENERIC ENDPOINT ********************/
    suspend fun getDataByEndpoint(endpoint: String): NamedDto {
        return safeApiCall<NamedDto>(endpoint)
    }

    /******************** POKEMON ********************/
    suspend fun getPokemon(id: Int): PokemonDto {
        return safeApiCall<PokemonDto>("${ApiEndpoints.ENDPOINT_POKEMON}$id/")
    }

    suspend fun getPokemon(name: String): PokemonDto {
        return safeApiCall<PokemonDto>("${ApiEndpoints.ENDPOINT_POKEMON}$name/")
    }

    suspend fun getPokemonAbility(id: Int): AbilityDto {
        return safeApiCall<AbilityDto>("${ApiEndpoints.ENDPOINT_ABILITY}$id/")
    }

    suspend fun getPokemonAbility(name: String): AbilityDto {
        return safeApiCall<AbilityDto>("${ApiEndpoints.ENDPOINT_ABILITY}$name/")
    }

    /******************** POKEMON SPECIES ********************/
    suspend fun getPokemonSpecies(id: Int): PokemonSpeciesDto {
        return safeApiCall<PokemonSpeciesDto>("${ApiEndpoints.ENDPOINT_POKEMON_SPECIES}$id/")
    }

    suspend fun getPokemonSpecies(name: String): PokemonSpeciesDto {
        return safeApiCall<PokemonSpeciesDto>("${ApiEndpoints.ENDPOINT_POKEMON_SPECIES}$name/")
    }

    /******************** HELPER ********************/
    // Api Caller Main Function
    private suspend inline fun <reified T : Any> safeApiCall(endpoint: String): T {
        val result = httpClient.get(endpoint)
        return result.body<T>()
    }
}