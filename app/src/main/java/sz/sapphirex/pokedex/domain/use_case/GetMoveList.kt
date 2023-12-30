package sz.sapphirex.pokedex.domain.use_case

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import sz.sapphirex.pokedex.domain.model.simple.moves.SimpleMove
import sz.sapphirex.pokedex.domain.model.utils.DataResult
import sz.sapphirex.pokedex.domain.repository.MoveListRepository
import javax.inject.Inject

class GetMoveList @Inject constructor(
    private val repository: MoveListRepository
) {
    operator fun invoke(): Flow<DataResult<PagingData<SimpleMove>>> {
        return repository.getMoveList()
    }
}