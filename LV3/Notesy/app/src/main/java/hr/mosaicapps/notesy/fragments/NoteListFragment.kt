package hr.mosaicapps.notesy.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import hr.mosaicapps.notesy.adapters.NotesAdapter
import hr.mosaicapps.notesy.databinding.FragmentNoteListBinding
import hr.mosaicapps.notesy.listeners.OnNoteSelectedListener
import hr.mosaicapps.notesy.persistence.NoteDao
import hr.mosaicapps.notesy.persistence.NotesDatabaseBuilder

class NoteListFragment : Fragment() {

    private lateinit var onNoteSelectedListener: OnNoteSelectedListener
    private lateinit var noteListBinding: FragmentNoteListBinding
    private val notesRepository: NoteDao by lazy {
        NotesDatabaseBuilder.getInstance().noteDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        noteListBinding = FragmentNoteListBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return noteListBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnNoteSelectedListener){
            onNoteSelectedListener = context
        }
    }

    override fun onResume() {
        super.onResume()
        (noteListBinding.rvNotes.adapter as NotesAdapter).refreshData(notesRepository.getNotes())
    }

    private fun setupRecyclerView(){
        noteListBinding.rvNotes.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        noteListBinding.rvNotes.adapter = NotesAdapter(notesRepository.getNotes(), onNoteSelectedListener)
    }

    companion object {
        const val TAG = "Notes list"
        fun create(): NoteListFragment {
            return NoteListFragment()
        }
    }
}


