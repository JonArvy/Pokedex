package sz.sapphirex.pokedex.domain.model.base.utility.commonmodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionEncounterDetail(
    val version: NamedAPIResource,
    @SerialName("max_chance") val maxChance: Int,
    @SerialName("encounter_details") val encounterDetails: List<Encounter>
)