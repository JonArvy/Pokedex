package sz.sapphirex.pokedex.domain.model.utils

import sz.sapphirex.pokedex.domain.utils.ApplicationLogger
import java.lang.Exception

sealed class DataResult<out T> {
    data class Success<out T>(val data: T): DataResult<T>()
    data class Error(val exception: Exception, val message: String = "Error"): DataResult<Nothing>()
    data object Loading : DataResult<Nothing>()

    inline fun <reified T> getSuccessResult(onError: (Exception) -> Unit = {}): T? = when (this) {
        is Success -> this.data as T?
        is Error -> {
            ApplicationLogger.apiLogger("DataResultModel Error: ${this.exception.message}")
            onError(this.exception)
            null
        }
        is Loading -> null
    }

    fun Error.getMessage(): String {
        return this.message
    }
}