package sz.sapphirex.pokedex.domain.model.base.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class PokemonColor(
    val id: Int,
    val name: String,
    val names: List<Name>,
    val pokemonSpecies: List<NamedAPIResource>
)