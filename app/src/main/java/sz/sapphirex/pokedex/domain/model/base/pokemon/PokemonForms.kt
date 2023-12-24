package sz.sapphirex.pokedex.domain.model.base.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class PokemonForm(
    val id: Int,
    val name: String,
    val order: Int,
    val formOrder: Int,
    val isDefault: Boolean,
    val isBattleOnly: Boolean,
    val isMega: Boolean,
    val formName: String,
    val pokemon: NamedAPIResource,
    val types: List<PokemonFormType>,
    val sprites: PokemonFormSprites,
    val versionGroup: NamedAPIResource,
    val names: List<Name>,
    val formNames: List<Name>
)

data class PokemonFormSprites(
    val frontDefault: String,
    val frontShiny: String,
    val backDefault: String,
    val backShiny: String
)