package sz.sapphirex.pokedex.data.remote.dto.resource

import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.local.entity.resource.NamedEntity
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto
import sz.sapphirex.pokedex.domain.model.base.resource.Named

@Serializable
data class NamedDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<NamedAPIResourceDto>
) {
    fun toBase(): Named {
        return Named(
            count = count,
            next = next,
            previous = previous,
            results = results.map { it.toBase() }
        )
    }

    fun toEntity(newId: String): NamedEntity {
        return NamedEntity(
            id = newId,
            count = count,
            next = next,
            previous = previous,
            results = results.map { it.toEntity() }
        )
    }
}