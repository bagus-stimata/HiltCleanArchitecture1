package com.example.hiltcleanarchitecture1.data.di;

import android.content.Context
import com.example.hiltcleanarchitecture1.Constants
import com.example.hiltcleanarchitecture1.data.local.AppDatabase
import com.example.hiltcleanarchitecture1.data.local.dao.CharacterDao
import com.example.hiltcleanarchitecture1.data.local.dao.ItemDao
import com.example.hiltcleanarchitecture1.data.local.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @DatabaseInfo
    fun providerDatabaseName(): String {
        return Constants.Table.DB_NAME
    }
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context, @DatabaseInfo dbName: String) = AppDatabase.getDatabase(appContext, dbName)

    @Singleton
    @Provides
    fun provideNoteDao(db: AppDatabase): NoteDao = db.noteDao()

    @Singleton
    @Provides
    fun provideCharacterDao(db: AppDatabase): CharacterDao = db.characterDao()

    @Singleton
    @Provides
    fun provideItemDao(db: AppDatabase): ItemDao = db.itemDao()

}