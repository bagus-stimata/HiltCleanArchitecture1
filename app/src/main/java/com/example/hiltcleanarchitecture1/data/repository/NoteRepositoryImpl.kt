package com.example.hiltcleanarchitecture1.data.repository

import androidx.lifecycle.LiveData
import com.example.hiltcleanarchitecture1.data.local.dao.NoteDao
import com.example.hiltcleanarchitecture1.data.local.entity.NoteEntity
import java.util.*
import javax.inject.Inject


/**
 * Created by wisnu on 8/7/18
 */
class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) {

    fun saveNote(content: String) {
        val noteDb = NoteEntity(id = generateUuid(), content = content)
//        println("Repository saveToNote: ${noteDb.id} and ${noteDb.content} Start")
        noteDao.insertNote(noteDb)
//        println("Repository saveToNote: ${noteDb.id} and ${noteDb.content} End")

    }

    fun loadNotesLiveData(): LiveData<List<NoteEntity>> {
        return noteDao.loadAllNotesLiveData()
    }

//    private fun generateUuid(): Int = UUID.randomUUID().toString().toInt()
    private fun generateUuid(): Int = Random().nextInt()

    fun deleteNote(note: NoteEntity) {
        noteDao.deleteNote(note.id)
    }

}