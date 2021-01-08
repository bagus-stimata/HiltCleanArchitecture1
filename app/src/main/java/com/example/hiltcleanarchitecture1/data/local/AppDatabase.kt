package com.example.hiltcleanarchitecture1.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hiltcleanarchitecture1.data.local.dao.CharacterDao
import com.example.hiltcleanarchitecture1.data.local.dao.ItemDao
import com.example.hiltcleanarchitecture1.data.local.dao.NoteDao
import com.example.hiltcleanarchitecture1.data.local.entity.CharacterEntity
import com.example.hiltcleanarchitecture1.data.local.entity.ItemEntity
import com.example.hiltcleanarchitecture1.data.local.entity.NoteEntity
import com.example.hiltcleanarchitecture1.data.local.entity.OwnerEntity

@Database(entities = [
    NoteEntity::class,
    CharacterEntity::class,
    ItemEntity::class,
    OwnerEntity::class
                     ], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
    abstract fun characterDao(): CharacterDao
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context, dbName: String): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context, dbName).also { instance = it } }

        private fun buildDatabase(appContext: Context, dbName: String) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, dbName)
                .fallbackToDestructiveMigration()
                .build()
    }

}