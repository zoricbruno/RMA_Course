package hr.mosaicapps.notesy.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.mosaicapps.notesy.R
import hr.mosaicapps.notesy.databinding.ActivityMainBinding
import hr.mosaicapps.notesy.fragments.NoteDetailsFragment
import hr.mosaicapps.notesy.fragments.NoteListFragment
import hr.mosaicapps.notesy.listeners.OnNoteSelectedListener
import hr.mosaicapps.notesy.model.Note

class MainActivity
    : AppCompatActivity(), OnNoteSelectedListener {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.fabAddNote.setOnClickListener{createNewNote()}
        setContentView(mainBinding.root)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.fl_fragmentContainer, NoteListFragment.create(), NoteListFragment.TAG)
                .commit()
        }
    }

    private fun createNewNote() {
        val newNoteIntent = Intent(this, NewNoteActivity::class.java)
        startActivity(newNoteIntent)
    }

    override fun OnNoteSelected(note: Note) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_fragmentContainer,
                NoteDetailsFragment.create(note),
                NoteDetailsFragment.TAG)
            .addToBackStack(null)
            .commit()
    }
}