package sz.sapphirex.pokedex.domain.model.base.pokemon.types

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.GenerationGameIndex
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.Name
import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.pokemon.types.TypePokemon
import sz.sapphirex.pokedex.domain.model.base.pokemon.types.TypeRelations
import sz.sapphirex.pokedex.domain.model.base.pokemon.types.TypeRelationsPast

@Serializable
data class Type(
    val id: Int,
    val name: String,
    @SerialName("damage_relations") val damageRelations: TypeRelations,
    @SerialName("past_damage_relations") val pastDamageRelations: List<TypeRelationsPast>,
    @SerialName("game_indices") val gameIndices: List<GenerationGameIndex>,
    val generation: NamedAPIResource,
    @SerialName("move_damage_class") val moveDamageClass: NamedAPIResource,
    val names: List<Name>,
    val pokemon: List<TypePokemon>,
    val moves: List<NamedAPIResource>
)