package sz.sapphirex.pokedex.domain.model.base.utility.commonmodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VerboseEffect(
    val effect: String,
    @SerialName("short_effect") val shortEffect: String,
    val language: NamedAPIResource,
)