package sz.sapphirex.pokedex.domain

import android.util.Log

class ApplicationLogger {
    companion object {
        fun appLogger(
            message: String?,
            type: Int = 0,
        ) {
            if (message != null) {
                when (type) {
                    0 -> Log.e("Domain Error", message)
                    1 -> Log.i("Domain Error", message)
                    2 -> Log.d("Domain Error", message)
                    3 -> Log.v("Domain Error", message)
                    4 -> Log.w("Domain Error", message)
                    5 -> Log.wtf("Domain Error", message)
                }
            } else {
                Log.e("Domain Error", "Message doesn't exist")
            }
        }

        fun apiLogger(
            message: String?,
            type: Int = 0,
        ) {
            if (message != null) {
                when (type) {
                    0 -> Log.e("PokeApiError", message)
                    1 -> Log.i("PokeApiError", message)
                    2 -> Log.d("PokeApiError", message)
                    3 -> Log.v("PokeApiError", message)
                    4 -> Log.w("PokeApiError", message)
                    5 -> Log.wtf("PokeApiError", message)
                }
            } else {
                Log.e("PokeApiError", "Message doesn't exist")
            }
        }
    }
}