package sz.sapphirex.pokedex.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import sz.sapphirex.pokedex.data.local.entity.pokemon.PokemonEntity
import sz.sapphirex.pokedex.data.local.entity.resource.NamedEntity

@Dao
interface PokemonDao {
    /** Pokemon **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: PokemonEntity)

    @Query("SELECT * FROM pokemon WHERE name = :id")
    suspend fun getPokemon(id: Int): PokemonEntity?

    @Query("SELECT * FROM pokemon WHERE name = :name")
    suspend fun getPokemon(name: String): PokemonEntity?

    @Query("SELECT * FROM pokemon")
    suspend fun getAllPokemon(): List<PokemonEntity>

    @Query("SELECT * FROM pokemon WHERE name IN(:nameList)")
    suspend fun getPokemonListByName(nameList: List<String>): List<PokemonEntity>

    @Query("SELECT * FROM pokemon WHERE name IN(:idList)")
    suspend fun getPokemonListById(idList: List<Int>): List<PokemonEntity>

    /** Named **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNamed(named: NamedEntity)

    @Query("SELECT * FROM named WHERE id =:id")
    suspend fun getNamed(id: String): NamedEntity?
}