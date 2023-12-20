package sz.sapphirex.pokedex.domain.model.base.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource
import sz.sapphirex.pokedex.domain.model.base.utility.VersionEncounterDetail

@Serializable
data class LocationAreaEncounter(
    @SerialName("location_area") val locationArea: NamedAPIResource,
    @SerialName("version_details")
    val versionDetails: List<VersionEncounterDetail>
)