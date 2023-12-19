package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemonshapes

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Name
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonShape(
    val id: Int,
    val name: String,
    @SerialName("awesome_names") val awesomeNames: List<AwesomeName>,
    val names: List<Name>,
    @SerialName("pokemon_species") val pokemonSpecies: List<NamedAPIResource>
)