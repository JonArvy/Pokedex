package sz.sapphirex.pokedex.domain.model.dto.resource

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

@Serializable
@Entity(tableName = "named")
data class Named(
    @PrimaryKey
    var id: String = "",
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<NamedAPIResource>
)