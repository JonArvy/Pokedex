package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemonspecies

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesDexEntry(
    @SerialName("entry_number") val entryNumber: Int,
    val pokedex: NamedAPIResource
)