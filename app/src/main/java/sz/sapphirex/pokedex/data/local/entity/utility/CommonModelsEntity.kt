package sz.sapphirex.pokedex.data.local.entity.utility

import sz.sapphirex.pokedex.domain.model.base.utility.APIResource
import sz.sapphirex.pokedex.domain.model.base.utility.Effect
import sz.sapphirex.pokedex.domain.model.base.utility.MachineVersionDetail
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource
import sz.sapphirex.pokedex.domain.model.base.utility.VerboseEffect
import sz.sapphirex.pokedex.domain.model.base.utility.VersionGameIndex

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
)

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
)

data class FlavorTextEntity(
    val flavorText: String,
    val language: NamedAPIResourceEntity,
    val version: NamedAPIResourceEntity
)

data class GenerationGameIndexEntity(
    val gameIndex: Int,
    val generation: NamedAPIResourceEntity
)

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
)

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
)
