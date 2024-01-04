package sz.sapphirex.pokedex.data.pagingsource

import android.net.Uri
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import sz.sapphirex.pokedex.data.local.PokemonDao
import sz.sapphirex.pokedex.data.remote.PokeApi
import sz.sapphirex.pokedex.domain.model.base.resource.Named
import sz.sapphirex.pokedex.domain.model.simple.pokemon.SimplePokemon
import sz.sapphirex.pokedex.domain.model.simple.pokemon.toSimple
import java.io.IOException

class PokemonPagingSource(
    private val initialEndpoint: String,
    private val api: PokeApi,
    private val dao: PokemonDao
): PagingSource<Int, SimplePokemon>() {
    override fun getRefreshKey(state: PagingState<Int, SimplePokemon>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestItemToPosition(anchorPosition)?.id
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SimplePokemon> {
        try {
            val endpoint = params.key?.let { "$initialEndpoint?offset=$it&limit=20" } ?: initialEndpoint
            Log.e("Endpoint", endpoint)
            val page: Named = dao.getNamed(endpoint)?.toBase() ?: api.getDataByEndpoint(endpoint).toBase()
            Log.e("Page", page.toString())
            val moveListName: List<String> = page.results.map { it.name }
            Log.e("Pokemon List Name", moveListName.toString())
            val moveList: List<SimplePokemon> = moveListName.map {
                dao.getPokemon(it)?.toBase()?.toSimple() ?: api.getPokemon(it).toBase().toSimple()
            }

            Log.e("Pokemon List", moveList.toString())

            val nextKey = page.next?.let {
                val uri = Uri.parse(it)
                uri.getQueryParameter("offset")?.toInt() ?: 0
            }

            val prevKey = page.previous?.let {
                val uri = Uri.parse(it)
                uri.getQueryParameter("offset")?.toInt() ?: 0
            }

            return LoadResult.Page(
                data = moveList,
                prevKey = nextKey,
                nextKey = prevKey
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

}