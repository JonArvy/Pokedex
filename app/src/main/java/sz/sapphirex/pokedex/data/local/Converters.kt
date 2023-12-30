package sz.sapphirex.pokedex.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import sz.sapphirex.pokedex.data.local.entity.moves.ContestComboSetsEntity
import sz.sapphirex.pokedex.data.local.entity.moves.MoveFlavorTextEntity
import sz.sapphirex.pokedex.data.local.entity.moves.MoveMetaDataEntity
import sz.sapphirex.pokedex.data.local.entity.moves.MoveStatChangeEntity
import sz.sapphirex.pokedex.data.local.entity.moves.PastMoveStatValuesEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.AbilityEffectChangeEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonAbilityEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonHeldItemEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonMoveEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonSpritesEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonStatEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonTypeEntity
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonTypePastEntity
import sz.sapphirex.pokedex.data.local.entity.utility.APIResourceEntity
import sz.sapphirex.pokedex.data.local.entity.utility.MachineVersionDetailEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NameEntity
import sz.sapphirex.pokedex.data.local.entity.utility.NamedAPIResourceEntity
import sz.sapphirex.pokedex.data.local.entity.utility.VerboseEffectEntity
import sz.sapphirex.pokedex.data.local.entity.utility.VersionGameIndexEntity
import sz.sapphirex.pokedex.data.local.util.JsonParser


@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromContestCombos(contestCombos: ContestComboSetsEntity): String {
        return toStringData(contestCombos)
    }

    @TypeConverter
    fun toContestCombos(contestCombosString: String): ContestComboSetsEntity {
        return toObjData(contestCombosString)
    }

    @TypeConverter
    fun fromEffectEntries(effectEntries: List<VerboseEffectEntity>): String {
        return toStringListData(effectEntries)
    }

    @TypeConverter
    fun toEffectEntries(effectEntriesString: String): List<VerboseEffectEntity> {
        return toObjListData(effectEntriesString)
    }

    @TypeConverter
    fun fromEffectChanges(effectChanges: List<AbilityEffectChangeEntity>): String {
        return toStringListData(effectChanges)
    }

    @TypeConverter
    fun toEffectChanges(effectChangesString: String): List<AbilityEffectChangeEntity> {
        return toObjListData(effectChangesString)
    }

    @TypeConverter
    fun fromFlavorTextEntries(flavorTextEntries: List<MoveFlavorTextEntity>): String {
        return toStringListData(flavorTextEntries)
    }

    @TypeConverter
    fun toFlavorTextEntries(flavorTextEntriesString: String): List<MoveFlavorTextEntity> {
        return toObjListData(flavorTextEntriesString)
    }

    @TypeConverter
    fun fromMachines(machines: List<MachineVersionDetailEntity>): String {
        return toStringListData(machines)
    }

    @TypeConverter
    fun toMachines(machinesString: String): List<MachineVersionDetailEntity> {
        return toObjListData(machinesString)
    }

    @TypeConverter
    fun fromMeta(meta: MoveMetaDataEntity): String {
        return toStringData(meta)
    }

    @TypeConverter
    fun toMeta(metaString: String): MoveMetaDataEntity {
        return toObjData(metaString)
    }

    @TypeConverter
    fun fromPastValues(pastValues: List<PastMoveStatValuesEntity>): String {
        return toStringListData(pastValues)
    }

    @TypeConverter
    fun toPastValues(pastValuesString: String): List<PastMoveStatValuesEntity> {
        return toObjListData(pastValuesString)
    }

    @TypeConverter
    fun fromStatChanges(statChanges: List<MoveStatChangeEntity>): String {
        return toStringListData(statChanges)
    }

    @TypeConverter
    fun toStatChanges(statChangesString: String): List<MoveStatChangeEntity> {
        return toObjListData(statChangesString)
    }

    @TypeConverter
    fun fromNameEntityList(nameEntity: List<NameEntity>): String {
        return toStringListData(nameEntity)
    }

    @TypeConverter
    fun toNameEntityList(nameEntityString: String): List<NameEntity> {
        return toObjListData(nameEntityString)
    }

    @TypeConverter
    fun fromAPIResourceEntity(apiResourceEntity: APIResourceEntity): String {
        return toStringData(apiResourceEntity)
    }

    @TypeConverter
    fun toAPIResourceEntity(apiResourceEntityString: String): APIResourceEntity {
        return toObjData(apiResourceEntityString)
    }

    @TypeConverter
    fun fromPokemonAbilitiesList(abilities: List<PokemonAbilityEntity>): String {
        return toStringListData(abilities)
    }

    @TypeConverter
    fun toPokemonAbilitiesList(abilitiesString: String): List<PokemonAbilityEntity> {
        return toObjListData(abilitiesString)
    }

    @TypeConverter
    fun fromNamedAPIResourceList(namedAPIResources: List<NamedAPIResourceEntity>): String {
        return toStringListData(namedAPIResources)
    }

    @TypeConverter
    fun toNamedAPIResourceList(namedAPIResourcesString: String): List<NamedAPIResourceEntity> {
        return toObjListData(namedAPIResourcesString)
    }

    @TypeConverter
    fun fromVersionGameIndexList(gameIndices: List<VersionGameIndexEntity>): String {
        return toStringListData(gameIndices)
    }

    @TypeConverter
    fun toVersionGameIndexList(gameIndicesString: String): List<VersionGameIndexEntity> {
        return toObjListData(gameIndicesString)
    }

    @TypeConverter
    fun fromPokemonHeldItemList(heldItems: List<PokemonHeldItemEntity>): String {
        return toStringListData(heldItems)
    }

    @TypeConverter
    fun toPokemonHeldItemList(heldItemsString: String): List<PokemonHeldItemEntity> {
        return toObjListData(heldItemsString)
    }

    @TypeConverter
    fun fromPokemonMoveList(moves: List<PokemonMoveEntity>): String {
        return toStringListData(moves)
    }

    @TypeConverter
    fun toPokemonMoveList(movesString: String): List<PokemonMoveEntity> {
        return toObjListData(movesString)
    }

    @TypeConverter
    fun fromPokemonTypePastList(pastTypes: List<PokemonTypePastEntity>): String {
        return toStringListData(pastTypes)
    }

    @TypeConverter
    fun toPokemonTypePastList(pastTypesString: String): List<PokemonTypePastEntity> {
        return toObjListData(pastTypesString)
    }

    @TypeConverter
    fun fromPokemonSprites(sprites: PokemonSpritesEntity): String {
        return toStringData(sprites)
    }

    @TypeConverter
    fun toPokemonSprites(spritesString: String): PokemonSpritesEntity {
        return toObjData(spritesString)
    }

    @TypeConverter
    fun fromNamedAPIResource(species: NamedAPIResourceEntity): String {
        return toStringData(species)
    }

    @TypeConverter
    fun toNamedAPIResource(speciesString: String): NamedAPIResourceEntity {
        return toObjData(speciesString)
    }

    @TypeConverter
    fun fromPokemonStatList(stats: List<PokemonStatEntity>): String {
        return toStringListData(stats)
    }

    @TypeConverter
    fun toPokemonStatList(statsString: String): List<PokemonStatEntity> {
        return toObjListData(statsString)
    }

    @TypeConverter
    fun fromPokemonTypeList(types: List<PokemonTypeEntity>): String {
        return toStringListData(types)
    }

    @TypeConverter
    fun toPokemonTypeList(typesString: String): List<PokemonTypeEntity> {
        return toObjListData(typesString)
    }

    /** Generics function to handle serialization for list and non list **/

    private inline fun <reified T> toObjData(string: String): T {
        return jsonParser.fromJson<T>(string, object : TypeToken<T>(){}.type) ?:
        throw JsonParseException("Failed to deserialize")
    }

    private inline fun <reified T> toStringData(list: T): String {
        return jsonParser.toJson(list, object : TypeToken<T>(){}.type) ?: "[]"
    }

    private inline fun <reified T> toObjListData(string: String): List<T> {
        return jsonParser.fromJson<ArrayList<T>>(string, object : TypeToken<ArrayList<T>>(){}.type) ?: emptyList()
    }

    private inline fun <reified T> toStringListData(list: List<T>): String {
        return jsonParser.toJson(list, object : TypeToken<ArrayList<T>>(){}.type) ?: "[]"
    }
}
