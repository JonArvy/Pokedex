package sz.sapphirex.pokedex.domain.model.base.pokemon.types

import sz.sapphirex.pokedex.domain.model.base.utility.commonmodels.NamedAPIResource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TypeRelations(
    @SerialName("no_damage_to") val noDamageTo: List<NamedAPIResource>,
    @SerialName("half_damage_to") val halfDamageTo: List<NamedAPIResource>,
    @SerialName("double_damage_to") val doubleDamageTo: List<NamedAPIResource>,
    @SerialName("no_damage_from") val noDamageFrom: List<NamedAPIResource>,
    @SerialName("half_damage_from") val halfDamageFrom: List<NamedAPIResource>,
    @SerialName("double_damage_from") val doubleDamageFrom: List<NamedAPIResource>
)