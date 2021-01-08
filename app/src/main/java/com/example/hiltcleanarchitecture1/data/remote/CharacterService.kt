package com.example.hiltcleanarchitecture1.data.remote

import com.example.hiltcleanarchitecture1.domain.model.Character
import com.example.hiltcleanarchitecture1.domain.model.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {
    @GET("character")
    suspend fun getAllCharacters() : Response<CharacterList>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Response<Character>
}