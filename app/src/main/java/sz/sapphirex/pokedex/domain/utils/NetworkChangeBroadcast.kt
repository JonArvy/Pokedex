package sz.sapphirex.pokedex.domain.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import sz.sapphirex.pokedex.domain.utils.makeToast

class NetworkChangeBroadcast: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.e("asdasdadasd", "Asdasdasdasda")
        context.makeToast("Network changed")
    }
}