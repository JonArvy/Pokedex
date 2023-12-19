package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemonlocationareas

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.VersionEncounterDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationAreaEncounter(
    @SerialName("location_area") val locationArea: NamedAPIResource,
    @SerialName("version_details")
    val versionDetails: List<VersionEncounterDetail>
)