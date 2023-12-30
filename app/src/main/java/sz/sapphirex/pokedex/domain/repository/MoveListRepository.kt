package sz.sapphirex.pokedex.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import sz.sapphirex.pokedex.domain.model.simple.moves.SimpleMove
import sz.sapphirex.pokedex.domain.model.utils.DataResult

interface MoveListRepository {
    fun getMoveList(): Flow<DataResult<PagingData<SimpleMove>>>

    fun searchMove(query: String): Flow<DataResult<List<SimpleMove>>>
}