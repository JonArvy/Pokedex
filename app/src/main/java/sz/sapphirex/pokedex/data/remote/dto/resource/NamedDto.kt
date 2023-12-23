package sz.sapphirex.pokedex.data.remote.dto.resource

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.data.remote.dto.utility.NamedAPIResourceDto
import sz.sapphirex.pokedex.domain.model.base.resource.Named

@Serializable
@Entity(tableName = "named")
data class NamedDto(
    @PrimaryKey
    var id: String = "",
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<NamedAPIResourceDto>
) {
    fun toNamed(): Named {
        return Named(
            id = id,
            count = count,
            next = next,
            previous = previous,
            results = results.map { it.toNamedAPIResource() }
        )
    }
}