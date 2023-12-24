package sz.sapphirex.pokedex.data.local.entity.games

import sz.sapphirex.pokedex.data.local.entity.utility.DescriptionEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class PokedexEntity(
    val id: Int,
    val name: String,
    val isMainSeries: Boolean,
    val descriptions: List<DescriptionEntity>,
    val names: List<NameEntity>,
    val pokemonEntries: List<PokemonEntryEntity>,
    val region: NamedAPIResourceEntity,
    val versionGroups: List<NamedAPIResourceEntity>
)

data class PokemonEntryEntity(
    val entryNumber: Int,
    val pokemonSpecies: NamedAPIResourceEntity
)