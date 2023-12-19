package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemonspecies

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.Serializable

@Serializable
data class Genus(
    val genus: String,
    val language: NamedAPIResource
)