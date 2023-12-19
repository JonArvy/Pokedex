package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.Serializable

@Serializable
data class PokemonType(
    val slot: Int,
    val type: NamedAPIResource
)
