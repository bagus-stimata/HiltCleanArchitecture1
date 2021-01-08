package com.example.hiltcleanarchitecture1.domain.repository

import com.example.hiltcleanarchitecture1.domain.model.Note
import io.reactivex.Observable
import io.reactivex.Single

interface NoteRepository : Repository {
//    fun insertNote(note: Note)
//    fun deleteNote(id: Int)
//    fun getById(id: Int): Single<Note>
    fun getAllData(content: String): Observable<List<Note>>
    fun getById(id: Int): Single<Note>

}