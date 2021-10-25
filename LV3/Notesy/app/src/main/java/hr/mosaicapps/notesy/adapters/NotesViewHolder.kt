package hr.mosaicapps.notesy.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import hr.mosaicapps.notesy.databinding.ItemNoteBinding
import hr.mosaicapps.notesy.utilities.getColorResource
import hr.mosaicapps.notesy.model.Note

class NotesViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    fun bind(note: Note) {
        val itemBinding = ItemNoteBinding.bind(itemView)
        itemBinding.tvNoteItemTitle.text = note.title
        itemBinding.tvNoteItemDetails.text = note.details
        itemBinding.ivNoteItemImportance.setBackgroundResource(
            getColorResource(note.priority)
        )
    }
}