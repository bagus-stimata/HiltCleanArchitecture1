package com.example.hiltcleanarchitecture1.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hiltcleanarchitecture1.Constants
import com.example.hiltcleanarchitecture1.data.local.entity.NoteEntity


/**
 * Created by wisnu on 8/7/18
 */
@Dao
interface NoteDao {

    @Query("SELECT * FROM ${Constants.Table.NOTE}")
    fun loadAllNotesLiveData(): LiveData<List<NoteEntity>>

    @Insert
    fun insertNote(note: NoteEntity)

    @Query("DELETE FROM ${Constants.Table.NOTE} WHERE id=:noteId")
    fun deleteNote(noteId: Int)

}