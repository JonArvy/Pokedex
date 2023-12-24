package sz.sapphirex.pokedex.domain.model.base.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class AwesomeName(
    val awesomeName: String,
    val language: NamedAPIResource
)

data class PokemonShape(
    val id: Int,
    val name: String,
    val awesomeNames: List<AwesomeName>,
    val names: List<Name>,
    val pokemonSpecies: List<NamedAPIResource>
)