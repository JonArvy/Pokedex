package sz.sapphirex.pokedex.domain.model.base.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

@Serializable
data class PokemonForm(
    val id: Int,
    val name: String,
    val order: Int,
    @SerialName("form_order") val formOrder: Int,
    @SerialName("is_default") val isDefault: Boolean,
    @SerialName("is_battle_only") val isBattleOnly: Boolean,
    @SerialName("is_mega") val isMega: Boolean,
    @SerialName("form_name") val formName: String,
    val pokemon: NamedAPIResource,
    val types: List<PokemonFormType>,
    val sprites: PokemonFormSprites,
    @SerialName("version_group") val versionGroup: NamedAPIResource,
    val names: List<Name>,
    @SerialName("form_names") val formNames: List<Name>
)

@Serializable
data class PokemonFormSprites(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_shiny") val backShiny: String
)