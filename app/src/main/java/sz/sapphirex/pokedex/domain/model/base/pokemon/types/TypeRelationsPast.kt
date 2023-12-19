package sz.sapphirex.pokedex.domain.model.base.pokemon.types

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TypeRelationsPast(
    val generation: NamedAPIResource,
    @SerialName("damage_relations") val damageRelations: TypeRelations
)