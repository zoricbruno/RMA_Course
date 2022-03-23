package hr.ferit.taskie.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hr.ferit.taskie.data.TaskDao
import hr.ferit.taskie.model.Task


@Database(
    entities = [Task::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TaskConverters::class)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    companion object {

        private const val databaseName = "notesDb"

        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): TaskDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                TaskDatabase::class.java,
                databaseName
            )
                    .allowMainThreadQueries()
                .build()
        }
    }
}