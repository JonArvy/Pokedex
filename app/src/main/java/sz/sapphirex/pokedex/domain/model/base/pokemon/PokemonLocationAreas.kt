package sz.sapphirex.pokedex.domain.model.base.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource
import sz.sapphirex.pokedex.domain.model.base.utility.VersionEncounterDetail

data class LocationAreaEncounter(
    val locationArea: NamedAPIResource,
    val versionDetails: List<VersionEncounterDetail>
)