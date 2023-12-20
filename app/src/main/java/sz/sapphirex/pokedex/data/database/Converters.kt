package sz.sapphirex.pokedex.data.database

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonAbility
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonHeldItem
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonMove
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonSprites
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonStat
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonType
import sz.sapphirex.pokedex.domain.model.base.pokemon.PokemonTypePast
import sz.sapphirex.pokedex.domain.model.base.pokemon.VersionGameIndex
import sz.sapphirex.pokedex.domain.model.base.utility.NamedAPIResource

class Converters {
    @TypeConverter
    fun fromPokemonAbilitiesList(abilities: List<PokemonAbility>): String {
        return Json.encodeToString(abilities)
    }

    @TypeConverter
    fun toPokemonAbilitiesList(abilitiesString: String): List<PokemonAbility> {
        return Json.decodeFromString(abilitiesString)
    }

    @TypeConverter
    fun fromNamedAPIResourceList(namedAPIResources: List<NamedAPIResource>): String {
        return Json.encodeToString(namedAPIResources)
    }

    @TypeConverter
    fun toNamedAPIResourceList(namedAPIResourcesString: String): List<NamedAPIResource> {
        return Json.decodeFromString(namedAPIResourcesString)
    }

    @TypeConverter
    fun fromVersionGameIndexList(gameIndices: List<VersionGameIndex>): String {
        return Json.encodeToString(gameIndices)
    }

    @TypeConverter
    fun toVersionGameIndexList(gameIndicesString: String): List<VersionGameIndex> {
        return Json.decodeFromString(gameIndicesString)
    }

    @TypeConverter
    fun fromPokemonHeldItemList(heldItems: List<PokemonHeldItem>): String {
        return Json.encodeToString(heldItems)
    }

    @TypeConverter
    fun toPokemonHeldItemList(heldItemsString: String): List<PokemonHeldItem> {
        return Json.decodeFromString(heldItemsString)
    }

    @TypeConverter
    fun fromPokemonMoveList(moves: List<PokemonMove>): String {
        return Json.encodeToString(moves)
    }

    @TypeConverter
    fun toPokemonMoveList(movesString: String): List<PokemonMove> {
        return Json.decodeFromString(movesString)
    }

    @TypeConverter
    fun fromPokemonTypePastList(pastTypes: List<PokemonTypePast>): String {
        return Json.encodeToString(pastTypes)
    }

    @TypeConverter
    fun toPokemonTypePastList(pastTypesString: String): List<PokemonTypePast> {
        return Json.decodeFromString(pastTypesString)
    }

    @TypeConverter
    fun fromPokemonSprites(sprites: PokemonSprites): String {
        return Json.encodeToString(sprites)
    }

    @TypeConverter
    fun toPokemonSprites(spritesString: String): PokemonSprites {
        return Json.decodeFromString(spritesString)
    }

    @TypeConverter
    fun fromNamedAPIResource(species: NamedAPIResource): String {
        return Json.encodeToString(species)
    }

    @TypeConverter
    fun toNamedAPIResource(speciesString: String): NamedAPIResource {
        return Json.decodeFromString(speciesString)
    }

    @TypeConverter
    fun fromPokemonStatList(stats: List<PokemonStat>): String {
        return Json.encodeToString(stats)
    }

    @TypeConverter
    fun toPokemonStatList(statsString: String): List<PokemonStat> {
        return Json.decodeFromString(statsString)
    }

    @TypeConverter
    fun fromPokemonTypeList(types: List<PokemonType>): String {
        return Json.encodeToString(types)
    }

    @TypeConverter
    fun toPokemonTypeList(typesString: String): List<PokemonType> {
        return Json.decodeFromString(typesString)
    }
}
