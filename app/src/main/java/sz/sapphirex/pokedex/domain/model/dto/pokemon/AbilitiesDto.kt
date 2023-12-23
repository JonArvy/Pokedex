package sz.sapphirex.pokedex.domain.model.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.dto.utility.EffectDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NameDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NamedAPIResourceDto
import sz.sapphirex.pokedex.domain.model.dto.utility.VerboseEffectDto

@Serializable
data class AbilityDto(
    val id: Int,
    val name: String,
    @SerialName("is_main_series") val isMainSeries: Boolean,
    val generation: NamedAPIResourceDto,
    val names: List<NameDto>,
    @SerialName("effect_entries") val effectEntries: List<VerboseEffectDto>,
    @SerialName("effect_changes") val effectChanges: List<AbilityEffectChangeDto>,
    @SerialName("flavor_text_entries") val flavorTextEntries: List<AbilityFlavorTextDto>,
    val pokemon: List<AbilityPokemonDto>
)

@Serializable
data class AbilityEffectChangeDto(
    @SerialName("effect_entries") val effectEntries: List<EffectDto>,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
)

@Serializable
data class AbilityFlavorTextDto(
    @SerialName("flavor_text") val flavorText: String,
    val language: NamedAPIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
)

@Serializable
data class AbilityPokemonDto(
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int,
    val pokemon: NamedAPIResourceDto
)