package sz.sapphirex.pokedex.domain.model.base.utility.commonmodels

import kotlinx.serialization.Serializable

@Serializable
data class NamedAPIResource(
    val name: String,
    val url: String
)