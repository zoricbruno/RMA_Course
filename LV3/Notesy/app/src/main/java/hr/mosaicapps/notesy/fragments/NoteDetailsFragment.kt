package hr.mosaicapps.notesy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.mosaicapps.notesy.databinding.FragmentNoteDetailsBinding
import hr.mosaicapps.notesy.utilities.getColorResource
import hr.mosaicapps.notesy.model.Note

class NoteDetailsFragment : Fragment() {

    lateinit var noteDetailsBinding: FragmentNoteDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        noteDetailsBinding = FragmentNoteDetailsBinding.inflate(
            inflater,
            container,
            false
        )

        arguments?.let {
            val note = it.getSerializable(KEY_NOTE) as Note
            noteDetailsBinding.tvNoteTitle.text = note.title
            noteDetailsBinding.ivNotePriority.setBackgroundResource(
                getColorResource(note.priority))
            noteDetailsBinding.tvNoteDetails.text = note.details
        }

        return noteDetailsBinding.root
    }

    companion object{

        const val TAG = "Details"
        private const val KEY_NOTE = "Note"

        fun create(note: Note): NoteDetailsFragment {
            val args = Bundle()
            args.putSerializable(KEY_NOTE, note)
            val fragment = NoteDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}