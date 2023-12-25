package sz.sapphirex.pokedex.core

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import sz.sapphirex.pokedex.core.utils.makeToast

class NetworkChangeBroadcast: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.e("asdasdadasd", "Asdasdasdasda")
        context.makeToast("Network changed")
    }
}