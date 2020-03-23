package com.example.task.ui.note

import androidx.annotation.VisibleForTesting
import com.example.task.data.NotesRepository
import com.example.task.data.entity.Note
import com.example.task.ui.base.BaseViewModel
import kotlinx.coroutines.launch

open class NoteViewModel(private val notesRepository: NotesRepository) : BaseViewModel<NoteData>() {

    private val currentNote: Note?
        get() = getViewState().poll()?.note

    fun save(note: Note) {
        setData(NoteData(note = note))
    }

    init {
        setData(NoteData())
    }

    fun loadNote(noteId: String) {
        launch {
            try {
                setData(NoteData(note = notesRepository.getNoteById(noteId)))
            } catch (e: Throwable) {
                setError(e)
            }

        }
    }

    fun deleteNote() {
        launch {
            try {
                currentNote?.let { notesRepository.deleteNote(it.id) }
                setData(NoteData(isDeleted = true))
            } catch (e: Throwable){
                setError(e)
            }
        }
    }

    @VisibleForTesting
    public override fun onCleared() {
        launch {
            currentNote?.let { notesRepository.saveNote(it) }
            super.onCleared()
        }
    }
}