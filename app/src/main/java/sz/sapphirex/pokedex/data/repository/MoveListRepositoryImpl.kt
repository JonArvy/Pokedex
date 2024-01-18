package sz.sapphirex.pokedex.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import sz.sapphirex.pokedex.data.local.PokemonDao
import sz.sapphirex.pokedex.data.pagingsource.MovePagingSource
import sz.sapphirex.pokedex.data.remote.ApiEndpoints.ENDPOINT_MOVE
import sz.sapphirex.pokedex.data.remote.PokeApi
import sz.sapphirex.pokedex.domain.model.simple.moves.SimpleMove
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.repository.MoveListRepository
import javax.inject.Inject

class MoveListRepositoryImpl @Inject constructor(
    private val pokeApi: PokeApi,
    private val dao: PokemonDao
) : MoveListRepository {
    override fun getMoveList(): Flow<PagingData<SimpleMove>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 2,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MovePagingSource(
                    initialEndpoint = ENDPOINT_MOVE,
                    api = pokeApi,
                    dao = dao
                )
            }
        ).flow
    }

    override fun searchMove(query: String): Flow<DataResult<List<SimpleMove>>> {
        TODO("Not yet implemented")
    }
}