package sz.sapphirex.pokedex.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import sz.sapphirex.pokedex.domain.model.simple.moves.SimpleMove
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.repository.MoveListRepository

class MoveListRepositoryImpl: MoveListRepository {
    override fun getMoveList(): Flow<DataResult<List<SimpleMove>>> = flow {
        emit(DataResult.Loading)
    }

    override fun searchMove(query: String): Flow<DataResult<List<SimpleMove>>> {
        TODO("Not yet implemented")
    }
}