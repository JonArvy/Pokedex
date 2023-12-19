package sz.sapphirex.pokedex.domain.model.base.games.pokedexes

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonEntry(
    @SerialName("entry_number") val entryNumber: Int,
    @SerialName("pokemon_species") val pokemonSpecies: NamedAPIResource
)