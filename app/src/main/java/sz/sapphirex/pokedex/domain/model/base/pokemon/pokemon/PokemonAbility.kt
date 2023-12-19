package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonAbility(
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int,
    val ability: NamedAPIResource,
)