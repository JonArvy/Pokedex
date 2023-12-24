package sz.sapphirex.pokedex.data.local.entity.pokemon

import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class AwesomeNameEntity(
    val awesomeName: String,
    val language: NamedAPIResourceEntity
)

data class PokemonShapeEntity(
    val id: Int,
    val name: String,
    val awesomeNames: List<AwesomeNameEntity>,
    val names: List<NameEntity>,
    val pokemonSpecies: List<NamedAPIResourceEntity>
)
