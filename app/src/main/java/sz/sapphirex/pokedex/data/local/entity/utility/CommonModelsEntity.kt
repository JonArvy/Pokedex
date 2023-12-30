package sz.sapphirex.pokedex.data.local.entity.utility

import sz.sapphirex.pokedex.domain.model.base.utility.APIResource
import sz.sapphirex.pokedex.domain.model.base.utility.Description
import sz.sapphirex.pokedex.domain.model.base.utility.Effect
import sz.sapphirex.pokedex.domain.model.base.utility.Encounter
import sz.sapphirex.pokedex.domain.model.base.utility.FlavorText
import sz.sapphirex.pokedex.domain.model.base.utility.GenerationGameIndex
import sz.sapphirex.pokedex.domain.model.base.utility.MachineVersionDetail
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource
import sz.sapphirex.pokedex.domain.model.base.utility.VerboseEffect
import sz.sapphirex.pokedex.domain.model.base.utility.VersionEncounterDetail
import sz.sapphirex.pokedex.domain.model.base.utility.VersionGameIndex
import sz.sapphirex.pokedex.domain.model.base.utility.VersionGroupFlavorText

data class APIResourceEntity(
    val url: String
) {
    fun toBase(): APIResource {
        return APIResource(
            url = url
        )
    }
}

data class DescriptionEntity(
    val description: String,
    val language: NamedAPIResourceEntity
) {
    fun toBase(): Description {
        return Description(
            description = description,
            language = language.toBase()
        )
    }
}

data class EffectEntity(
    val effect: String,
    val language: NamedAPIResourceEntity
) {
    fun toBase(): Effect {
        return Effect(
            effect = effect,
            language = language.toBase()
        )
    }
}

data class EncounterEntity(
    val minLevel: Int,
    val maxLevel: Int,
    val conditionValues: List<NamedAPIResourceEntity>,
    val chance: Int,
    val method: NamedAPIResourceEntity
) {
    fun toBase(): Encounter {
        return Encounter(
            minLevel = minLevel,
            maxLevel = maxLevel,
            conditionValues = conditionValues.map { it.toBase() },
            chance = chance,
            method = method.toBase()
        )
    }
}

data class FlavorTextEntity(
    val flavorText: String,
    val language: NamedAPIResourceEntity,
    val version: NamedAPIResourceEntity
) {
    fun toBase(): FlavorText {
        return FlavorText(
            flavorText = flavorText,
            language = language.toBase(),
            version = version.toBase()
        )
    }
}

data class GenerationGameIndexEntity(
    val gameIndex: Int,
    val generation: NamedAPIResourceEntity
) {
    fun toBase(): GenerationGameIndex {
        return GenerationGameIndex(
            gameIndex = gameIndex,
            generation = generation.toBase()
        )
    }
}

data class MachineVersionDetailEntity(
    val machine: APIResourceEntity,
    val versionGroup: NamedAPIResourceEntity
) {
    fun toBase(): MachineVersionDetail {
        return MachineVersionDetail(
            machine = machine.toBase(),
            versionGroup = versionGroup.toBase()
        )
    }
}

data class NameEntity(
    val name: String,
    val language: NamedAPIResourceEntity
) {
    fun toBase(): Name {
        return Name(
            name = name,
            language = language.toBase()
        )
    }
}

data class NamedAPIResourceEntity(
    val name: String,
    val url: String
) {
    fun toBase(): NamedAPIResource {
        return NamedAPIResource(
            name = name,
            url = url
        )
    }
}

data class VerboseEffectEntity(
    val effect: String,
    val shortEffect: String,
    val language: NamedAPIResourceEntity
) {
    fun toBase(): VerboseEffect {
        return VerboseEffect(
            effect = effect,
            shortEffect = shortEffect,
            language = language.toBase()
        )
    }
}

data class VersionEncounterDetailEntity(
    val version: NamedAPIResourceEntity,
    val maxChance: Int,
    val encounterDetails: List<EncounterEntity>
) {
    fun toBase(): VersionEncounterDetail {
        return VersionEncounterDetail(
            version = version.toBase(),
            maxChance = maxChance,
            encounterDetails = encounterDetails.map { it.toBase() }
        )
    }
}

data class VersionGameIndexEntity(
    val gameIndex: Int,
    val version: NamedAPIResourceEntity
) {
    fun toBase(): VersionGameIndex {
        return VersionGameIndex(
            gameIndex = gameIndex,
            version = version.toBase()
        )
    }
}

data class VersionGroupFlavorTextEntity(
    val text: String,
    val language: NamedAPIResourceEntity,
    val versionGroup: NamedAPIResourceEntity
) {
    fun toBase(): VersionGroupFlavorText {
        return VersionGroupFlavorText(
            text = text,
            language = language.toBase(),
            versionGroup = versionGroup.toBase()
        )
    }
}
