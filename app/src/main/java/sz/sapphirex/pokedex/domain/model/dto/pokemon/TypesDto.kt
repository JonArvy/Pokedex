package sz.sapphirex.pokedex.domain.model.dto.pokemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sz.sapphirex.pokedex.domain.model.dto.utility.GenerationGameIndexDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NameDto
import sz.sapphirex.pokedex.domain.model.dto.utility.NamedAPIResourceDto

@Serializable
data class TypeDto(
    val id: Int,
    val name: String,
    @SerialName("damage_relations") val damageRelations: TypeRelationsDto,
    @SerialName("past_damage_relations") val pastDamageRelations: List<TypeRelationsPastDto>,
    @SerialName("game_indices") val gameIndices: List<GenerationGameIndexDto>,
    val generation: NamedAPIResourceDto,
    @SerialName("move_damage_class") val moveDamageClass: NamedAPIResourceDto,
    val names: List<NameDto>,
    val pokemon: List<TypePokemonDto>,
    val moves: List<NamedAPIResourceDto>
)

@Serializable
data class TypePokemonDto(
    val slot: Int,
    val pokemon: NamedAPIResourceDto
)

@Serializable
data class TypeRelationsDto(
    @SerialName("no_damage_to") val noDamageTo: List<NamedAPIResourceDto>,
    @SerialName("half_damage_to") val halfDamageTo: List<NamedAPIResourceDto>,
    @SerialName("double_damage_to") val doubleDamageTo: List<NamedAPIResourceDto>,
    @SerialName("no_damage_from") val noDamageFrom: List<NamedAPIResourceDto>,
    @SerialName("half_damage_from") val halfDamageFrom: List<NamedAPIResourceDto>,
    @SerialName("double_damage_from") val doubleDamageFrom: List<NamedAPIResourceDto>
)

@Serializable
data class TypeRelationsPastDto(
    val generation: NamedAPIResourceDto,
    @SerialName("damage_relations") val damageRelations: TypeRelationsDto
)