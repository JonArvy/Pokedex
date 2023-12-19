package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonMove(
    val move: NamedAPIResource,
    @SerialName("version_group_details") val versionGroupDetails: List<PokemonMoveVersion>,
)