package hr.mosaicapps.notesy.persistence

import androidx.room.*
import hr.mosaicapps.notesy.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * FROM notes WHERE id=:id")
    fun getNote(id: Long): Note

}