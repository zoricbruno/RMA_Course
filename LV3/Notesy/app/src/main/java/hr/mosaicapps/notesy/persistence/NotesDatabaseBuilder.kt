package hr.mosaicapps.notesy.persistence

import androidx.room.Room
import hr.mosaicapps.notesy.Notesy

object NotesDatabaseBuilder {

    private var instance: NotesDatabase? = null

    fun getInstance(): NotesDatabase {
        synchronized(NotesDatabase::class) {
            if (instance == null) {
                instance = buildDatabase()
            }
        }
        return instance!!
    }

    private fun buildDatabase(): NotesDatabase {
        return Room.databaseBuilder(
            Notesy.application, NotesDatabase::class.java, NotesDatabase.NAME
        )
            .allowMainThreadQueries()
            .build()
    }
}