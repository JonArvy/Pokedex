package sz.sapphirex.pokedex.domain.model.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.dto.utility.NameDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NamedAPIResourceDto

@Serializable
data class PokemonFormDto(
    val id: Int,
    val name: String,
    val order: Int,
    @SerialName("form_order") val formOrder: Int,
    @SerialName("is_default") val isDefault: Boolean,
    @SerialName("is_battle_only") val isBattleOnly: Boolean,
    @SerialName("is_mega") val isMega: Boolean,
    @SerialName("form_name") val formName: String,
    val pokemon: NamedAPIResourceDto,
    val types: List<PokemonFormTypeDto>,
    val sprites: PokemonFormSpritesDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto,
    val names: List<NameDto>,
    @SerialName("form_names") val formNames: List<NameDto>
)

@Serializable
data class PokemonFormSpritesDto(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_shiny") val backShiny: String
)