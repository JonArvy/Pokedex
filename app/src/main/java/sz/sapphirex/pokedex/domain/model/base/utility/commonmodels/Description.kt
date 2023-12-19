package sz.sapphirex.pokedex.domain.model.base.utility.commonmodels

import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource

@Serializable
data class Description(
    val description: String,
    val language: NamedAPIResource
)