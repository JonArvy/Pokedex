package sz.sapphirex.pokedex.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import sz.sapphirex.pokedex.domain.model.base.pokemon.Pokemon
import sz.sapphirex.pokedex.domain.model.base.resource.Named

@Dao
interface PokemonDao {
    /** Pokemon **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: Pokemon)

    @Query("SELECT * FROM pokemon WHERE name = :name")
    suspend fun getPokemon(name: String): Pokemon?

    @Query("SELECT * FROM pokemon")
    suspend fun getAllPokemon(): List<Pokemon>

    @Query("SELECT * FROM pokemon WHERE name IN(:nameList)")
    suspend fun getPokemonListByName(nameList: List<String>): List<Pokemon>

    @Query("SELECT * FROM pokemon WHERE name IN(:idList)")
    suspend fun getPokemonListById(idList: List<Int>): List<Pokemon>

    /** Named **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNamed(named: Named)

    @Query("SELECT * FROM named WHERE id =:id")
    suspend fun getNamed(id: String): Named?
}