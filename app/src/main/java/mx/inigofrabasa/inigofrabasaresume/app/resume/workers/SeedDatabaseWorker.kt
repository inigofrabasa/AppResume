package mx.inigofrabasa.inigofrabasaresume.app.resume.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.AppDatabase
import mx.inigofrabasa.inigofrabasaresume.app.resume.data.Skill
import mx.inigofrabasa.inigofrabasaresume.app.resume.utilities.SKILL_DATA_FILENAME
import kotlinx.coroutines.coroutineScope

class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val TAG by lazy { SeedDatabaseWorker::class.java.simpleName }

    override suspend fun doWork(): Result = coroutineScope {

        try {
            applicationContext.assets.open(SKILL_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val skillType = object : TypeToken<List<Skill>>() {}.type
                    val skillList: List<Skill> = Gson().fromJson(jsonReader, skillType)

                    val database = AppDatabase.getInstance(applicationContext)
                    database.skillDao().insertAll(skillList)

                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }
}