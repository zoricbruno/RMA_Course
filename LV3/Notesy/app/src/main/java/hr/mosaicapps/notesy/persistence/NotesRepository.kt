package hr.mosaicapps.notesy.persistence

import hr.mosaicapps.notesy.model.Note

object NotesRepository {

    private val notes = mutableListOf<Note>(
        Note(0,"Enjoy the sun", "Drink coffee", 1),
        Note(0,"Go to a party", "Drink beer", 1),
        Note(0,"Read a book", "Clean code", 2),
        Note(0,"Ride bike", "At least 10km", 3),
        Note(0,"Buy groceries", "Bread, milk, cheese", 1),
    )

    fun getNotes(): List<Note> = notes
    fun getNote(title: String): Note = notes.first { it -> it.title == title }
    fun insert(note: Note) = notes.add(note)
    fun delete(note: Note) = notes.remove(note)
}