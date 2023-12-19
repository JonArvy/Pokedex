package sz.sapphirex.pokedex.domain.model.base.resource

import androidx.room.Entity
import androidx.room.PrimaryKey
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.Serializable

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