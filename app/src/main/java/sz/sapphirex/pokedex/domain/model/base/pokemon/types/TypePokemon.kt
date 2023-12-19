package sz.sapphirex.pokedex.domain.model.base.pokemon.types

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.Serializable

@Serializable
data class TypePokemon(
    val slot: Int,
    val pokemon: NamedAPIResource
)