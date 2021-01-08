package com.example.hiltcleanarchitecture1.data.repository

import com.example.hiltcleanarchitecture1.data.local.dao.CharacterDao
import com.example.hiltcleanarchitecture1.data.local.entity.CharacterEntity
import com.example.hiltcleanarchitecture1.data.local.entity.CharacterEntityMapper
import com.example.hiltcleanarchitecture1.data.remote.CharacterRemoteDataSource
import com.example.hiltcleanarchitecture1.data.utils.performGetOperation
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val remoteDataSource: CharacterRemoteDataSource,
    private val localDataSource: CharacterDao
) {

//    fun getCharacter(id: Int) = performGetOperation(
//        databaseQuery = { localDataSource.getCharacter(id) },
//        networkCall = { remoteDataSource.getCharacter(id) },
//        saveCallResult = { localDataSource.insert(CharacterEntityMapper().mapToEntity(it)) }
//    )
//
//    fun getCharacters() = performGetOperation(
//        databaseQuery = { localDataSource.getAllCharacters() },
//        networkCall = { remoteDataSource.getCharacters() },
//        saveCallResult = { localDataSource.insertAll(it.results) }
//    )

}