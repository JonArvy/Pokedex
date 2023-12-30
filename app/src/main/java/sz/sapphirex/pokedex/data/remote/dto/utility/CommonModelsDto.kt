package sz.sapphirex.pokedex.data.remote.dto.utility

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity
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
) {
    fun toBase(): APIResource {
        return APIResource(url = url)
    }
}

@Serializable
data class DescriptionDto(
    val description: String,
    val language: NamedAPIResourceDto
) {
    fun toBase(): Description {
        return Description(
            description = description,
            language = language.toBase()
        )
    }
}

@Serializable
data class EffectDto(
    val effect: String,
    val language: NamedAPIResourceDto
) {
    fun toBase(): Effect {
        return Effect(
            effect = effect,
            language = language.toBase()
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

@Serializable
data class FlavorTextDto(
    @SerialName("flavor_text") val flavorText: String,
    val language: NamedAPIResourceDto,
    val version: NamedAPIResourceDto,
) {
    fun toBase(): FlavorText {
        return FlavorText(
            flavorText = flavorText,
            language = language.toBase(),
            version = version.toBase()
        )
    }
}

@Serializable
data class GenerationGameIndexDto(
    @SerialName("game_index") val gameIndex: Int,
    val generation: NamedAPIResourceDto
) {
    fun toBase():GenerationGameIndex {
        return GenerationGameIndex(
            gameIndex = gameIndex,
            generation = generation.toBase()
        )
    }
}

@Serializable
data class MachineVersionDetailDto(
    val machine: APIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
) {
    fun toBase(): MachineVersionDetail {
        return MachineVersionDetail(
            machine = machine.toBase(),
            versionGroup = versionGroup.toBase()
        )
    }
}

@Serializable
data class NameDto(
    val name: String,
    val language: NamedAPIResourceDto
) {
    fun toBase(): Name {
        return Name(
            name = name,
            language = language.toBase()
        )
    }
}

@Serializable
data class NamedAPIResourceDto(
    val name: String,
    val url: String
) {
    fun toBase(): NamedAPIResource {
        return NamedAPIResource(
            name = name,
            url = url
        )
    }

    fun toEntity(): NamedAPIResourceEntity {
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
) {
    fun toBase(): VerboseEffect {
        return VerboseEffect(
            effect = effect,
            shortEffect = shortEffect,
            language = language.toBase()
        )
    }
}

@Serializable
data class VersionEncounterDetailDto(
    val version: NamedAPIResourceDto,
    @SerialName("max_chance") val maxChance: Int,
    @SerialName("encounter_details") val encounterDetails: List<EncounterDto>
) {
    fun toBase(): VersionEncounterDetail {
        return VersionEncounterDetail(
            version = version.toBase(),
            maxChance = maxChance,
            encounterDetails = encounterDetails.map { it.toBase() }
        )
    }
}

@Serializable
data class VersionGameIndexDto(
    @SerialName("game_index") val gameIndex: Int,
    val version: NamedAPIResourceDto
) {
    fun toBase(): VersionGameIndex {
        return VersionGameIndex(
            gameIndex = gameIndex,
            version = version.toBase()
        )
    }
}

@Serializable
data class VersionGroupFlavorTextDto(
    val text: String,
    val language: NamedAPIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
) {
    fun toBase(): VersionGroupFlavorText {
        return VersionGroupFlavorText(
            text = text,
            language = language.toBase(),
            versionGroup = versionGroup.toBase()
        )
    }
}
