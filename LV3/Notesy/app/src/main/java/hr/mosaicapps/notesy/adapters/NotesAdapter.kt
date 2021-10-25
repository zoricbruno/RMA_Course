package hr.mosaicapps.notesy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.mosaicapps.notesy.R
import hr.mosaicapps.notesy.listeners.OnNoteSelectedListener
import hr.mosaicapps.notesy.model.Note

class NotesAdapter(
    notes: List<Note>,
    private val listener: OnNoteSelectedListener
) :
    RecyclerView.Adapter<NotesViewHolder>() {

    private val  notes: MutableList<Note> = mutableListOf()
    init{
        refreshData(notes)
    }

    public fun refreshData(notes: List<Note>) {
        this.notes.clear()
        this.notes.addAll(notes)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
        holder.itemView.setOnClickListener{listener.OnNoteSelected(note)}
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}