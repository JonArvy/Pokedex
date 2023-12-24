package sz.sapphirex.pokedex.data.local.entity.resource

import androidx.room.Entity
import androidx.room.PrimaryKey
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity
import sz.sapphirex.pokedex.domain.model.base.resource.Named

@Entity(tableName = "named")
data class NamedEntity(
    @PrimaryKey
    var id: String = "",
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<NamedAPIResourceEntity>
) {
    fun toBase(): Named {
        return Named(
            count = count,
            next = next,
            previous = previous,
            results = results.map { it.toBase() }
        )
    }
}