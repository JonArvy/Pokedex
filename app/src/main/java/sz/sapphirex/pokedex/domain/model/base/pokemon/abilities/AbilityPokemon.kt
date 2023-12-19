package sz.sapphirex.pokedex.domain.model.base.pokemon.abilities

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityPokemon(
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int,
    val pokemon: NamedAPIResource
)