package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemonspecies

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesVariety(
    @SerialName("is_default")
    val isDefault: Boolean,
    val pokemon: NamedAPIResource
)