package com.example.hiltcleanarchitecture1.data.local.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hiltcleanarchitecture1.Constants
import com.example.hiltcleanarchitecture1.data.local.entity.ItemEntity
import com.example.hiltcleanarchitecture1.data.local.entity.NoteEntity
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable


/**
 * Created by wisnu on 8/7/18
 */
@Dao
interface ItemDao {

    @Query("SELECT * FROM ${Constants.Table.ITEM}")
//    fun findAll(): LiveData<List<ItemEntity>>
//    fun findAll(): MutableList<ItemEntity>
//    fun findAll(): List<ItemEntity>
    fun findAll(): Observable<List<ItemEntity>> //Flowable = Observable

    @Query("SELECT * FROM ${Constants.Table.ITEM} WHERE id =:id")
//    fun findById(id: Int) : Single<ItemEntity>
    fun findById(id: Int) : Maybe<ItemEntity> //make sure you’re calling subscribeOn with a different Scheduler than AndroidSchedulers.mainThread()
//    fun findById(id: Int) : Flowable<ItemEntity>  //Flowable = Observable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    @Insert
    fun insertNote(note: ItemEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<ItemEntity>)

    @Query("DELETE FROM ${Constants.Table.ITEM} WHERE id =:id")
    fun deleteNote(id: Int)

}