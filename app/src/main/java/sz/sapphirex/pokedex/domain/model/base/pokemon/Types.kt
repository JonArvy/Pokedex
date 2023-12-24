package sz.sapphirex.pokedex.domain.model.base.pokemon

import sz.sapphirex.pokedex.domain.model.base.utility.GenerationGameIndex
import sz.sapphirex.pokedex.domain.model.base.utility.Name
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

data class Type(
    val id: Int,
    val name: String,
    val damageRelations: TypeRelations,
    val pastDamageRelations: List<TypeRelationsPast>,
    val gameIndices: List<GenerationGameIndex>,
    val generation: NamedAPIResource,
    val moveDamageClass: NamedAPIResource,
    val names: List<Name>,
    val pokemon: List<TypePokemon>,
    val moves: List<NamedAPIResource>
)

data class TypePokemon(
    val slot: Int,
    val pokemon: NamedAPIResource
)

data class TypeRelations(
    val noDamageTo: List<NamedAPIResource>,
    val halfDamageTo: List<NamedAPIResource>,
    val doubleDamageTo: List<NamedAPIResource>,
    val noDamageFrom: List<NamedAPIResource>,
    val halfDamageFrom: List<NamedAPIResource>,
    val doubleDamageFrom: List<NamedAPIResource>
)

data class TypeRelationsPast(
    val generation: NamedAPIResource,
    val damageRelations: TypeRelations
)