package com.example.hiltcleanarchitecture1.presentation.fragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.hiltcleanarchitecture1.data.repository.NoteRepositoryImpl
import com.example.hiltcleanarchitecture1.domain.model.Note

class ListViewModel  @ViewModelInject constructor(private val noteRepository: NoteRepositoryImpl) : ViewModel() {
    private lateinit var notesResult: LiveData<List<Note>>
    init {
        subscribeNoteResult()
    }

    fun saveNote(content: String) {
        println("Model saveToNote Start")
        noteRepository.saveNote(content)
        println("Model saveToNote End")
    }


    fun listenNotesResult(): LiveData<List<Note>> {
        return notesResult
    }

    private fun subscribeNoteResult() {
        notesResult = noteRepository.loadNotesLiveData().map { data ->
            data.reversed().map { Note(it.id, it.content) }
        }
    }

}