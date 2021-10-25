package hr.mosaicapps.notesy.listeners

import hr.mosaicapps.notesy.model.Note

interface OnNoteSelectedListener {
    fun OnNoteSelected(note: Note)
}