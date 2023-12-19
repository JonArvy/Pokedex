package sz.sapphirex.pokedex.domain.model

import sz.sapphirex.pokedex.domain.ApplicationLogger.Companion.apiLogger
import kotlin.Exception

@Deprecated("This class is deprecated, move to DataResult", ReplaceWith("DataResult"))
sealed class ApiResult<out T> {
    @Deprecated("This class is deprecated, move to DataResult", ReplaceWith("DataResult"))
    data class Success<out T>(val data: T): ApiResult<T>()
    @Deprecated("This class is deprecated, move to DataResult", ReplaceWith("DataResult"))
    data class Error(val exception: Exception): ApiResult<Nothing>()
    @Deprecated("This object is deprecated, move to DataResult", ReplaceWith("DataResult"))
    data object Loading : ApiResult<Nothing>()

    @Deprecated("This method is deprecated, use DataResult.getSuccessResult() instead", ReplaceWith("DataResult.getSuccessResult()"))
    inline fun <reified T> getSuccessResult(onError: (Exception) -> Unit = {}): T? = when (this) {
        is Success -> this.data as T?
        is Error -> {
            apiLogger("ApiResultModel Error: ${this.exception.message}")
            onError(this.exception)
            null
        }
        is Loading -> null
    }

    @Deprecated("This method is deprecated, use DataResult.getMessage() instead", ReplaceWith("DataResult.getMessage()"))
    fun Error.getMessage(): String {
        return "Error"
    }
}