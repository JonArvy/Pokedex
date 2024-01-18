package sz.sapphirex.pokedex.data.remote.dto.utility

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.local.entity.utility.APIResourceEntity
import sz.sapphirex.pokedex.data.local.entity.utility.DescriptionEntity
import sz.sapphirex.pokedex.data.local.entity.utility.EffectEntity
import sz.sapphirex.pokedex.data.local.entity.utility.EncounterEntity
import sz.sapphirex.pokedex.data.local.entity.utility.FlavorTextEntity
import sz.sapphirex.pokedex.data.local.entity.utility.GenerationGameIndexEntity
import sz.sapphirex.pokedex.data.local.entity.utility.MachineVersionDetailEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity
import sz.sapphirex.pokedex.data.local.entity.utility.VerboseEffectEntity
import sz.sapphirex.pokedex.data.local.entity.utility.VersionEncounterDetailEntity
import sz.sapphirex.pokedex.data.local.entity.utility.VersionGameIndexEntity
import sz.sapphirex.pokedex.data.local.entity.utility.VersionGroupFlavorTextEntity
import sz.sapphirex.pokedex.data.remote.dto.DtoInterface
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

@Serializable
data class APIResourceDto(
    val url: String
): DtoInterface {
    override fun toBase(): APIResource {
        return APIResource(url = url)
    }

    override fun toEntity(): APIResourceEntity {
        return APIResourceEntity(url = url)
    }
}

@Serializable
data class DescriptionDto(
    val description: String,
    val language: NamedAPIResourceDto
): DtoInterface {
    override fun toBase(): Description {
        return Description(
            description = description,
            language = language.toBase()
        )
    }

    override fun toEntity(): DescriptionEntity {
        return DescriptionEntity(
            description = description,
            language = language.toEntity()
        )
    }
}

@Serializable
data class EffectDto(
    val effect: String,
    val language: NamedAPIResourceDto
): DtoInterface {
    override fun toBase(): Effect {
        return Effect(
            effect = effect,
            language = language.toBase()
        )
    }

    override fun toEntity(): EffectEntity {
        return EffectEntity(
            effect = effect,
            language = language.toEntity()
        )
    }
}

@Serializable
data class EncounterDto(
    @SerialName("min_level") val minLevel: Int,
    @SerialName("max_level") val maxLevel: Int,
    @SerialName("condition_values") val conditionValues: List<NamedAPIResourceDto>,
    val chance: Int,
    val method: NamedAPIResourceDto
): DtoInterface {
    override fun toBase(): Encounter {
        return Encounter(
            minLevel = minLevel,
            maxLevel = maxLevel,
            conditionValues = conditionValues.map { it.toBase() },
            chance = chance,
            method = method.toBase()
        )
    }

    override fun toEntity(): EncounterEntity {
        return EncounterEntity(
            minLevel = minLevel,
            maxLevel = maxLevel,
            conditionValues = conditionValues.map { it.toEntity() },
            chance = chance,
            method = method.toEntity()
        )
    }
}

@Serializable
data class FlavorTextDto(
    @SerialName("flavor_text") val flavorText: String,
    val language: NamedAPIResourceDto,
    val version: NamedAPIResourceDto,
): DtoInterface {
    override fun toBase(): FlavorText {
        return FlavorText(
            flavorText = flavorText,
            language = language.toBase(),
            version = version.toBase()
        )
    }

    override fun toEntity(): FlavorTextEntity {
        return FlavorTextEntity(
            flavorText = flavorText,
            language = language.toEntity(),
            version = version.toEntity()
        )
    }
}

@Serializable
data class GenerationGameIndexDto(
    @SerialName("game_index") val gameIndex: Int,
    val generation: NamedAPIResourceDto
): DtoInterface {
    override fun toBase():GenerationGameIndex {
        return GenerationGameIndex(
            gameIndex = gameIndex,
            generation = generation.toBase()
        )
    }

    override fun toEntity(): GenerationGameIndexEntity {
        return GenerationGameIndexEntity(
            gameIndex = gameIndex,
            generation = generation.toEntity()
        )
    }
}

@Serializable
data class MachineVersionDetailDto(
    val machine: APIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
): DtoInterface {
    override fun toBase(): MachineVersionDetail {
        return MachineVersionDetail(
            machine = machine.toBase(),
            versionGroup = versionGroup.toBase()
        )
    }

    override fun toEntity(): MachineVersionDetailEntity {
        return MachineVersionDetailEntity(
            machine = machine.toEntity(),
            versionGroup = versionGroup.toEntity()
        )
    }
}

@Serializable
data class NameDto(
    val name: String,
    val language: NamedAPIResourceDto
): DtoInterface {
    override fun toBase(): Name {
        return Name(
            name = name,
            language = language.toBase()
        )
    }

    override fun toEntity(): NameEntity {
        return NameEntity(
            name = name,
            language = language.toEntity()
        )
    }
}

@Serializable
data class NamedAPIResourceDto(
    val name: String,
    val url: String
): DtoInterface {
    override fun toBase(): NamedAPIResource {
        return NamedAPIResource(
            name = name,
            url = url
        )
    }

    override fun toEntity(): NamedAPIResourceEntity {
        return NamedAPIResourceEntity(
            name = name,
            url = url
        )
    }
}

@Serializable
data class VerboseEffectDto(
    val effect: String,
    @SerialName("short_effect") val shortEffect: String,
    val language: NamedAPIResourceDto,
): DtoInterface {
    override fun toBase(): VerboseEffect {
        return VerboseEffect(
            effect = effect,
            shortEffect = shortEffect,
            language = language.toBase()
        )
    }

    override fun toEntity(): VerboseEffectEntity {
        return VerboseEffectEntity(
            effect = effect,
            shortEffect = shortEffect,
            language = language.toEntity()
        )
    }
}

@Serializable
data class VersionEncounterDetailDto(
    val version: NamedAPIResourceDto,
    @SerialName("max_chance") val maxChance: Int,
    @SerialName("encounter_details") val encounterDetails: List<EncounterDto>
): DtoInterface {
    override fun toBase(): VersionEncounterDetail {
        return VersionEncounterDetail(
            version = version.toBase(),
            maxChance = maxChance,
            encounterDetails = encounterDetails.map { it.toBase() }
        )
    }

    override fun toEntity(): VersionEncounterDetailEntity {
        return VersionEncounterDetailEntity(
            version = version.toEntity(),
            maxChance = maxChance,
            encounterDetails = encounterDetails.map { it.toEntity() }
        )
    }
}

@Serializable
data class VersionGameIndexDto(
    @SerialName("game_index") val gameIndex: Int,
    val version: NamedAPIResourceDto
): DtoInterface {
    override fun toBase(): VersionGameIndex {
        return VersionGameIndex(
            gameIndex = gameIndex,
            version = version.toBase()
        )
    }

    override fun toEntity(): VersionGameIndexEntity {
        return VersionGameIndexEntity(
            gameIndex = gameIndex,
            version = version.toEntity()
        )
    }
}

@Serializable
data class VersionGroupFlavorTextDto(
    val text: String,
    val language: NamedAPIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
): DtoInterface {
    override fun toBase(): VersionGroupFlavorText {
        return VersionGroupFlavorText(
            text = text,
            language = language.toBase(),
            versionGroup = versionGroup.toBase()
        )
    }

    override fun toEntity(): VersionGroupFlavorTextEntity {
        return VersionGroupFlavorTextEntity(
            text = text,
            language = language.toEntity(),
            versionGroup = versionGroup.toEntity()
        )
    }
}
