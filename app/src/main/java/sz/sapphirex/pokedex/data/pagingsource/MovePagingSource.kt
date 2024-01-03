package sz.sapphirex.pokedex.data.pagingsource

import android.net.Uri
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import sz.sapphirex.pokedex.data.local.PokemonDao
import sz.sapphirex.pokedex.data.remote.PokeApi
import sz.sapphirex.pokedex.domain.model.base.resource.Named
import sz.sapphirex.pokedex.domain.model.simple.moves.SimpleMove
import java.io.IOException

class MovePagingSource(
    private val initialEndpoint: String,
    private val api: PokeApi,
    private val dao: PokemonDao,
): PagingSource<Int, SimpleMove>() {
    override fun getRefreshKey(state: PagingState<Int, SimpleMove>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestItemToPosition(anchorPosition)?.id
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SimpleMove> {
        try {
            val endpoint = params.key?.let { "$initialEndpoint?offset=$it&limit=20" } ?: initialEndpoint
            Log.e("Endpoint", endpoint)
            val page: Named = dao.getNamed(endpoint)?.toBase() ?: api.getDataByEndpoint(endpoint).toBase()
            Log.e("Page", page.toString())
            val moveListName: List<String> = page.results.map { it.name }
            Log.e("Move List Name", moveListName.toString())
            val moveList: List<SimpleMove> = moveListName.map {
                dao.getMove(it)?.toBase()?.toSimple() ?: api.getMove(it).toBase().toSimple()
            }

            Log.e("Move List", moveList.toString())

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
            Log.e("Move List", e.message.toString())
            return LoadResult.Error(e)
        } catch (e: Exception) {
            Log.e("Move List", e.message.toString())
            return LoadResult.Error(e)
        }
    }
}