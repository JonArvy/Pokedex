package sz.sapphirex.pokedex.domain.model.base.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.base.utility.GenerationGameIndex
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

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

@Serializable
data class TypePokemon(
    val slot: Int,
    val pokemon: NamedAPIResource
)

@Serializable
data class TypeRelations(
    @SerialName("no_damage_to") val noDamageTo: List<NamedAPIResource>,
    @SerialName("half_damage_to") val halfDamageTo: List<NamedAPIResource>,
    @SerialName("double_damage_to") val doubleDamageTo: List<NamedAPIResource>,
    @SerialName("no_damage_from") val noDamageFrom: List<NamedAPIResource>,
    @SerialName("half_damage_from") val halfDamageFrom: List<NamedAPIResource>,
    @SerialName("double_damage_from") val doubleDamageFrom: List<NamedAPIResource>
)

@Serializable
data class TypeRelationsPast(
    val generation: NamedAPIResource,
    @SerialName("damage_relations") val damageRelations: TypeRelations
)