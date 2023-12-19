package sz.sapphirex.pokedex.domain.model.base.pokemon.pokemonforms

import sz.sapphirex.pokedex.domain.model.base.pokemon.pokemon.PokemonFormType
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Name
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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