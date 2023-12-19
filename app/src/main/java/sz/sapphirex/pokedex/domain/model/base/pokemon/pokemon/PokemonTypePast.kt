package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon.PokemonType

@Serializable
data class PokemonTypePast(
    val generation: NamedAPIResource,
    val types: List<PokemonType>
)