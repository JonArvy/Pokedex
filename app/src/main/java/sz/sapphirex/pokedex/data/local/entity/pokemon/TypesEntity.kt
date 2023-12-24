package sz.sapphirex.pokedex.data.local.entity.pokemon

import sz.sapphirex.pokedex.data.local.entity.utility.GenerationGameIndexEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity

data class TypeEntity(
    val id: Int,
    val name: String,
    val damageRelations: TypeRelationsEntity,
    val pastDamageRelations: List<TypeRelationsPastEntity>,
    val gameIndices: List<GenerationGameIndexEntity>,
    val generation: NamedAPIResourceEntity,
    val moveDamageClass: NamedAPIResourceEntity,
    val names: List<NameEntity>,
    val pokemon: List<TypePokemonEntity>,
    val moves: List<NamedAPIResourceEntity>
)

data class TypePokemonEntity(
    val slot: Int,
    val pokemon: NamedAPIResourceEntity
)

data class TypeRelationsEntity(
    val noDamageTo: List<NamedAPIResourceEntity>,
    val halfDamageTo: List<NamedAPIResourceEntity>,
    val doubleDamageTo: List<NamedAPIResourceEntity>,
    val noDamageFrom: List<NamedAPIResourceEntity>,
    val halfDamageFrom: List<NamedAPIResourceEntity>,
    val doubleDamageFrom: List<NamedAPIResourceEntity>
)

data class TypeRelationsPastEntity(
    val generation: NamedAPIResourceEntity,
    val damageRelations: TypeRelationsEntity
)