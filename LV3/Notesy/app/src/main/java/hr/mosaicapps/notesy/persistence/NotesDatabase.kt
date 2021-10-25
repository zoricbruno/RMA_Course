package hr.mosaicapps.notesy.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import hr.mosaicapps.notesy.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        const val NAME = "notesDb"
    }
}

