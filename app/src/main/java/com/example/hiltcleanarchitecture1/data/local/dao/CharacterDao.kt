package com.example.hiltcleanarchitecture1.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hiltcleanarchitecture1.Constants
import com.example.hiltcleanarchitecture1.data.local.entity.CharacterEntity
import com.example.hiltcleanarchitecture1.domain.model.Character


/**
 * Created by wisnu on 8/7/18
 */
@Dao
interface CharacterDao {

    @Query("SELECT * FROM ${Constants.Table.CHARACTER}")
    fun getAllCharacters() : LiveData<List<CharacterEntity>>

    @Query("SELECT * FROM ${Constants.Table.CHARACTER} WHERE id = :id")
    fun getCharacter(id: Int): LiveData<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<CharacterEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: CharacterEntity)

}