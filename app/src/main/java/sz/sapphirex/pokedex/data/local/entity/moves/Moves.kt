package sz.sapphirex.pokedex.data.local.entity.moves

import androidx.room.Entity
import androidx.room.PrimaryKey
import sz.sapphirex.pokedex.data.local.entity.EntityInterface
import sz.sapphirex.pokedex.data.local.entity.pokemon.AbilityEffectChangeEntity
import sz.sapphirex.pokedex.data.local.entity.utility.APIResourceEntity
import sz.sapphirex.pokedex.data.local.entity.utility.MachineVersionDetailEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity
import sz.sapphirex.pokedex.data.local.entity.utility.VerboseEffectEntity
import sz.sapphirex.pokedex.data.remote.dto.moves.MoveDto
import sz.sapphirex.pokedex.domain.model.base.moves.ContestComboDetail
import sz.sapphirex.pokedex.domain.model.base.moves.ContestComboSets
import sz.sapphirex.pokedex.domain.model.base.moves.Move
import sz.sapphirex.pokedex.domain.model.base.moves.MoveFlavorText
import sz.sapphirex.pokedex.domain.model.base.moves.MoveMetaData
import sz.sapphirex.pokedex.domain.model.base.moves.MoveStatChange
import sz.sapphirex.pokedex.domain.model.base.moves.PastMoveStatValues

@Entity(tableName = "move")
data class MoveEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val accuracy: Int?,
    val effectChance: Int?,
    val pp: Int?,
    val priority: Int,
    val power: Int?,
    val contestCombos: ContestComboSetsEntity?,
    val contestType: NamedAPIResourceEntity,
    val contestEffect: APIResourceEntity,
    val damageClass: NamedAPIResourceEntity,
    val effectEntries: List<VerboseEffectEntity>,
    val effectChanges: List<AbilityEffectChangeEntity>,
    val learnedByPokemon: List<NamedAPIResourceEntity>,
    val flavorTextEntries: List<MoveFlavorTextEntity>,
    val generation: NamedAPIResourceEntity,
    val machines: List<MachineVersionDetailEntity>,
    val meta: MoveMetaDataEntity,
    val names: List<NameEntity>,
    val pastValues: List<PastMoveStatValuesEntity>,
    val statChanges: List<MoveStatChangeEntity>,
    val superContestEffect: APIResourceEntity,
    val target: NamedAPIResourceEntity,
    val type: NamedAPIResourceEntity?
): EntityInterface {
    override fun toBase(): Move {
        return Move(
            id = id,
            name = name,
            accuracy = accuracy,
            effectChance = effectChance,
            pp = pp,
            priority = priority,
            power = power,
            contestCombos = contestCombos?.toBase(),
            contestType = contestType.toBase(),
            contestEffect = contestEffect.toBase(),
            damageClass = damageClass.toBase(),
            effectEntries = effectEntries.map { it.toBase() },
            effectChanges = effectChanges.map { it.toBase() },
            learnedByPokemon = learnedByPokemon.map { it.toBase() },
            flavorTextEntries = flavorTextEntries.map { it.toBase() },
            generation = generation.toBase(),
            machines = machines.map { it.toBase() },
            meta = meta.toBase(),
            names = names.map { it.toBase() },
            pastValues = pastValues.map { it.toBase() },
            statChanges = statChanges.map { it.toBase() },
            superContestEffect = superContestEffect.toBase(),
            target = target.toBase(),
            type = type?.toBase()
        )
    }

    override fun toDto(): MoveDto {
        TODO("Not yet implemented")
    }
}

data class ContestComboSetsEntity(
    val normal: ContestComboDetailEntity,
    val superr: ContestComboDetailEntity
) {
    fun toBase(): ContestComboSets {
        return ContestComboSets(
            normal = normal.toBase(),
            superr = superr.toBase()
        )
    }
}

data class ContestComboDetailEntity(
    val useBefore: List<NamedAPIResourceEntity>?,
    val useAfter: List<NamedAPIResourceEntity>?
) {
    fun toBase(): ContestComboDetail {
        return ContestComboDetail(
            useBefore = useBefore?.map { it.toBase() },
            useAfter = useAfter?.map { it.toBase() }
        )
    }
}

data class MoveFlavorTextEntity(
    val flavorText: String,
    val language: NamedAPIResourceEntity,
    val versionGroup: NamedAPIResourceEntity
) {
    fun toBase(): MoveFlavorText {
        return MoveFlavorText(
            flavorText = flavorText,
            language = language.toBase(),
            versionGroup = versionGroup.toBase()
        )
    }
}

data class MoveMetaDataEntity(
    val ailment: NamedAPIResourceEntity,
    val category: NamedAPIResourceEntity,
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
) {
    fun toBase(): MoveMetaData {
        return MoveMetaData(
            ailment = ailment.toBase(),
            category = category.toBase(),
            minHits = minHits,
            maxHits = maxHits,
            minTurns = minTurns,
            maxTurns = maxTurns,
            drain = drain,
            healing = healing,
            critRate = critRate,
            ailmentChance = ailmentChance,
            flinchChance = flinchChance,
            statChance = statChance
        )
    }
}

data class MoveStatChangeEntity(
    val change: Int,
    val stat: NamedAPIResourceEntity
) {
    fun toBase(): MoveStatChange {
        return MoveStatChange(
            change = change,
            stat = stat.toBase()
        )
    }
}

data class PastMoveStatValuesEntity(
    val accuracy: Int?,
    val effectChance: Int?,
    val power: Int?,
    val pp: Int?,
    val effectEntries: List<VerboseEffectEntity>,
    val type: NamedAPIResourceEntity?,
    val versionGroup: NamedAPIResourceEntity
) {
    fun toBase(): PastMoveStatValues {
        return PastMoveStatValues(
            accuracy = accuracy,
            effectChance = effectChance,
            power = power,
            pp = pp,
            effectEntries = effectEntries.map { it.toBase() },
            type = type?.toBase(),
            versionGroup = versionGroup.toBase()
        )
    }
}