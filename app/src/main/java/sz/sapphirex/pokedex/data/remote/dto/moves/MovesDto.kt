package sz.sapphirex.pokedex.data.remote.dto.moves

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.remote.dto.pokemon.AbilityEffectChangeDto
import sz.sapphirex.pokedex.data.remote.dto.utility.APIResourceDto
import sz.sapphirex.pokedex.data.remote.dto.utility.MachineVersionDetailDto
import sz.sapphirex.pokedex.data.remote.dto.utility.NameDto
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto
import sz.sapphirex.pokedex.data.remote.dto.utility.VerboseEffectDto

@Serializable
data class MoveDto(
    val id: Int,
    val name: String,
    val accuracy: Int,
    @SerialName("effect_chance") val effectChance: Int,
    val pp: Int,
    val priority: Int,
    val power: Int,
    @SerialName("contest_combos") val contestCombos: ContestComboSetsDto,
    @SerialName("contest_type") val contestType: NamedAPIResourceDto,
    @SerialName("contest_effect") val contestEffect: APIResourceDto,
    @SerialName("damage_class") val damageClass: NamedAPIResourceDto,
    @SerialName("effect_entries") val effectEntries: List<VerboseEffectDto>,
    @SerialName("effect_changes") val effectChanges: List<AbilityEffectChangeDto>,
    @SerialName("learned_by_pokemon") val learnedByPokemon: List<NamedAPIResourceDto>,
    @SerialName("flavor_text_entries") val flavorTextEntries: List<MoveFlavorTextDto>,
    @SerialName("generation") val generation: NamedAPIResourceDto,
    val machines: List<MachineVersionDetailDto>,
    val meta: MoveMetaDataDto,
    val names: List<NameDto>,
    @SerialName("past_values") val pastValues: List<PastMoveStatValuesDto>,
    @SerialName("stat_changes") val statChanges: List<MoveStatChangeDto>,
    @SerialName("super_contest_effect") val superContestEffect: APIResourceDto,
    val target: NamedAPIResourceDto,
    val type: NamedAPIResourceDto
)

@Serializable
data class ContestComboSetsDto(
    val normal: ContestComboDetailDto,
    @SerialName("super") val superr: ContestComboDetailDto
)

@Serializable
data class ContestComboDetailDto(
    @SerialName("use_before") val useBefore: List<NamedAPIResourceDto>,
    @SerialName("use_after") val useAfter: List<NamedAPIResourceDto>
)

@Serializable
data class MoveFlavorTextDto(
    @SerialName("flavor_text") val flavorText: String,
    val language: NamedAPIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
)

@Serializable
data class MoveMetaDataDto(
    val ailment: NamedAPIResourceDto,
    val category: NamedAPIResourceDto,
    @SerialName("min_hits") val minHits: Int?,
    @SerialName("max_hits") val maxHits: Int?,
    @SerialName("min_turns") val minTurns: Int?,
    @SerialName("max_turns") val maxTurns: Int?,
    val drain: Int,
    val healing: Int,
    @SerialName("crit_rate") val critRate: Int,
    @SerialName("ailment_chance") val ailmentChance: Int,
    @SerialName("flinch_chance") val flinchChance: Int,
    @SerialName("stat_chance") val statChance: Int
)

@Serializable
data class MoveStatChangeDto(
    val change: Int,
    val stat: NamedAPIResourceDto
)

@Serializable
data class PastMoveStatValuesDto(
    val accuracy: Int,
    @SerialName("effect_chance") val effectChance: Int,
    val power: Int,
    val pp: Int,
    @SerialName("effect_entries") val effectEntries: List<VerboseEffectDto>,
    val type: NamedAPIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
)