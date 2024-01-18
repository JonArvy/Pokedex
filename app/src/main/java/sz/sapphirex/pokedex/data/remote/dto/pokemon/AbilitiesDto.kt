package sz.sapphirex.pokedex.data.remote.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.local.entity.pokemon.AbilityEffectChangeEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.AbilityEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.AbilityFlavorTextEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.AbilityPokemonEntity
import sz.sapphirex.pokedex.data.remote.dto.DtoInterface
import sz.sapphirex.pokedex.data.remote.dto.utility.EffectDto
import sz.sapphirex.pokedex.data.remote.dto.utility.NameDto
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto
import sz.sapphirex.pokedex.data.remote.dto.utility.VerboseEffectDto
import sz.sapphirex.pokedex.domain.model.base.pokemon.Ability
import sz.sapphirex.pokedex.domain.model.base.pokemon.AbilityEffectChange
import sz.sapphirex.pokedex.domain.model.base.pokemon.AbilityFlavorText
import sz.sapphirex.pokedex.domain.model.base.pokemon.AbilityPokemon

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
): DtoInterface {
    override fun toBase(): Ability {
        return Ability(
            id = id,
            name = name,
            isMainSeries = isMainSeries,
            generation = generation.toBase(),
            names = names.map { it.toBase() },
            effectEntries = effectEntries.map { it.toBase() },
            effectChanges = effectChanges.map { it.toBase() },
            flavorTextEntries = flavorTextEntries.map { it.toBase() },
            pokemon = pokemon.map { it.toBase() }
        )
    }

    override fun toEntity(): AbilityEntity {
        return AbilityEntity(
            id = id,
            name = name,
            isMainSeries = isMainSeries,
            generation = generation.toEntity(),
            names = names.map { it.toEntity() },
            effectEntries = effectEntries.map { it.toEntity() },
            effectChanges = effectChanges.map { it.toEntity() },
            flavorTextEntries = flavorTextEntries.map { it.toEntity() },
            pokemon = pokemon.map { it.toEntity() }
        )
    }

}

@Serializable
data class AbilityEffectChangeDto(
    @SerialName("effect_entries") val effectEntries: List<EffectDto>,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
): DtoInterface {
    override fun toBase(): AbilityEffectChange {
        return AbilityEffectChange(
            effectEntries = effectEntries.map { it.toBase() },
            versionGroup = versionGroup.toBase()
        )
    }

    override fun toEntity(): AbilityEffectChangeEntity {
        return AbilityEffectChangeEntity(
            effectEntries = effectEntries.map { it.toEntity() },
            versionGroup = versionGroup.toEntity()
        )
    }
}

@Serializable
data class AbilityFlavorTextDto(
    @SerialName("flavor_text") val flavorText: String,
    val language: NamedAPIResourceDto,
    @SerialName("version_group") val versionGroup: NamedAPIResourceDto
): DtoInterface {
    override fun toBase(): AbilityFlavorText {
        return AbilityFlavorText(
            flavorText = flavorText,
            language = language.toBase(),
            versionGroup = versionGroup.toBase()
        )
    }

    override fun toEntity(): AbilityFlavorTextEntity {
        return AbilityFlavorTextEntity(
            flavorText = flavorText,
            language = language.toEntity(),
            versionGroup = versionGroup.toEntity()
        )
    }
}

@Serializable
data class AbilityPokemonDto(
    @SerialName("is_hidden") val isHidden: Boolean,
    val slot: Int,
    val pokemon: NamedAPIResourceDto
): DtoInterface {
    override fun toBase(): AbilityPokemon {
        return AbilityPokemon(
            isHidden = isHidden,
            slot = slot,
            pokemon = pokemon.toBase()
        )
    }

    override fun toEntity(): AbilityPokemonEntity {
        return AbilityPokemonEntity(
            isHidden = isHidden,
            slot = slot,
            pokemon = pokemon.toEntity()
        )
    }
}