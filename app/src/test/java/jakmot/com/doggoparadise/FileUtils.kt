package jakmot.com.doggoparadise

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.io.BufferedReader
import java.io.InputStreamReader

class FileUtils {
    val moshi: Moshi = Moshi.Builder().build()

    inline fun <reified T> loadFromFile(fileName: String): T? {
        val adapter: JsonAdapter<T> = moshi.adapter(T::class.java)
        val file = loadFile(fileName)
        return adapter.fromJson(file)
    }

    fun loadFile(fileName: String): String {
        return FileUtils::class.java.getResourceAsStream("/${fileName}").use { inputStream ->
            InputStreamReader(inputStream).use { inputStreamReader ->
                BufferedReader(inputStreamReader).use { bufferedReader ->
                    bufferedReader.readText()
                }
            }
        }
    }

}