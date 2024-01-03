package sz.sapphirex.pokedex.domain.model.base.moves

import sz.sapphirex.pokedex.domain.model.base.pokemon.AbilityEffectChange
import sz.sapphirex.pokedex.domain.model.base.utility.APIResource
import sz.sapphirex.pokedex.domain.model.base.utility.MachineVersionDetail
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource
import sz.sapphirex.pokedex.domain.model.base.utility.VerboseEffect
import sz.sapphirex.pokedex.domain.model.simple.moves.SimpleMove

data class Move(
    val id: Int,
    val name: String,
    val accuracy: Int?,
    val effectChance: Int?,
    val pp: Int?,
    val priority: Int,
    val power: Int?,
    val contestCombos: ContestComboSets?,
    val contestType: NamedAPIResource,
    val contestEffect: APIResource,
    val damageClass: NamedAPIResource,
    val effectEntries: List<VerboseEffect>,
    val effectChanges: List<AbilityEffectChange>,
    val learnedByPokemon: List<NamedAPIResource>,
    val flavorTextEntries: List<MoveFlavorText>,
    val generation: NamedAPIResource,
    val machines: List<MachineVersionDetail>,
    val meta: MoveMetaData,
    val names: List<Name>,
    val pastValues: List<PastMoveStatValues>,
    val statChanges: List<MoveStatChange>,
    val superContestEffect: APIResource,
    val target: NamedAPIResource,
    val type: NamedAPIResource?
) {
    fun toSimple(): SimpleMove {
        return SimpleMove(
            id = id,
            name = name,
            type = type
        )
    }
}

data class ContestComboSets(
    val normal: ContestComboDetail,
    val superr: ContestComboDetail
)

data class ContestComboDetail(
    val useBefore: List<NamedAPIResource>?,
    val useAfter: List<NamedAPIResource>?
)

data class MoveFlavorText(
    val flavorText: String,
    val language: NamedAPIResource,
    val versionGroup: NamedAPIResource
)

data class MoveMetaData(
    val ailment: NamedAPIResource,
    val category: NamedAPIResource,
    val minHits: Int?,
    val maxHits: Int?,
    val minTurns: Int?,
    val maxTurns: Int?,
    val drain: Int,
    val healing: Int,
    val critRate: Int,
    val ailmentChance: Int,
    val flinchChance: Int,
    val statChance: Int
)

data class MoveStatChange(
    val change: Int,
    val stat: NamedAPIResource
)

data class PastMoveStatValues(
    val accuracy: Int?,
    val effectChance: Int?,
    val power: Int?,
    val pp: Int?,
    val effectEntries: List<VerboseEffect>,
    val type: NamedAPIResource?,
    val versionGroup: NamedAPIResource
)