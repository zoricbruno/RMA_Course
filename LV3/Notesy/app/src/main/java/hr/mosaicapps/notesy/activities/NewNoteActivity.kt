package hr.mosaicapps.notesy.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.mosaicapps.notesy.databinding.ActivityNewNoteBinding
import hr.mosaicapps.notesy.model.Note
import hr.mosaicapps.notesy.persistence.NoteDao
import hr.mosaicapps.notesy.persistence.NotesDatabaseBuilder

class NewNoteActivity : AppCompatActivity() {

    private lateinit var newNoteBinding: ActivityNewNoteBinding
    private val notesRepository: NoteDao by lazy {
        NotesDatabaseBuilder.getInstance().noteDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newNoteBinding = ActivityNewNoteBinding.inflate(layoutInflater)
        newNoteBinding.bNewNoteSave.setOnClickListener{saveNote()}
        setContentView(newNoteBinding.root)
    }

    private fun saveNote() {
        val title = newNoteBinding.etNewNoteTitleInput.text.toString()
        val details = newNoteBinding.etNewNoteDetailsInput.text.toString()
        val priority = newNoteBinding.etNewNotePriorityInput.text.toString().toInt()
        val note = Note(0, title, details, priority)
        notesRepository.insert(note)
        finish()
    }
}