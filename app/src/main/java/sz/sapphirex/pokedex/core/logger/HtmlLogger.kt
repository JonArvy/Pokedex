package sz.sapphirex.pokedex.core.logger

import android.content.Context
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileWriter
import java.io.IOException
import javax.inject.Inject

class HtmlLogger {
    private val fileName = "log.html"
    private val downloadFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
    private val filePath: String = File(downloadFolder, fileName).absolutePath

    init {
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            val logFile = File(filePath)
            if (!logFile.exists()) {
                try {
                    logFile.createNewFile()
                    Log.e("File created:", filePath)
                } catch (e: IOException) {
                    Log.e("File Error:", "failed to create a file in $filePath")
                    e.printStackTrace()
                }
            }
        } else {
            Log.e("Storage Error:", "External storage is not mounted or not writable")
        }
    }

    fun appendLogToFile(message: String) {
        val logEntry = "<p>$message</p>"
        try {
            FileWriter(filePath, true).use { writer ->
                writer.appendLine(logEntry)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}