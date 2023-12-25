package sz.sapphirex.pokedex.core.logger

import android.util.Log
import javax.inject.Inject

class PokedexLogger @Inject constructor(
    private val htmlLogger: HtmlLogger
): Logger {
    override fun database(tag: String, message: String, nested: Boolean, severity: Int) {
        loggerMainFunction("Database: $tag", message, nested, severity)
    }

    override fun api(tag: String, message: String, nested: Boolean, severity: Int) {
        loggerMainFunction("Api: $tag", message, nested, severity)
    }

    override fun model(tag: String, message: String, nested: Boolean, severity: Int) {
        loggerMainFunction("Model: $tag", message, nested, severity)
    }

    override fun serialization(tag: String, message: String, nested: Boolean, severity: Int) {
        loggerMainFunction("Generic: $tag", message, nested, severity)
    }

    override fun generic(tag: String, message: String, nested: Boolean, severity: Int) {
        loggerMainFunction(tag, message, nested, severity)
    }

    private fun loggerMainFunction(tag: String, message: String, nested: Boolean, severity: Int) {
        val finalTag = if (nested) "    $tag" else tag
        val finalMessage = "Log: $message"
        when (severity) {
            1 -> {
                htmlLogger.appendLogToFile("<font color=\"black\">$finalTag || $finalMessage</font>")
                Log.v(finalTag, finalMessage)
            }
            2 -> {
                htmlLogger.appendLogToFile("<font color=\"blue\">$finalTag || $finalMessage</font>")
                Log.d(finalTag, finalMessage)
            }
            3 -> {
                htmlLogger.appendLogToFile("<font color=\"green\">$finalTag || $finalMessage</font>")
                Log.i(finalTag, finalMessage)
            }
            4 -> {
                htmlLogger.appendLogToFile("<font color=\"orange\">$finalTag || $finalMessage</font>")
                Log.w(finalTag, finalMessage)
            }
            5 -> {
                htmlLogger.appendLogToFile("<font color=\"red\">$finalTag || $finalMessage</font>")
                Log.w(finalTag, finalMessage)
            }
        }
    }
}