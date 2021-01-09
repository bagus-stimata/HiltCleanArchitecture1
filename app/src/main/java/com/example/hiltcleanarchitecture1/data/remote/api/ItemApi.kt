package com.example.hiltcleanarchitecture1.data.remote.api

import com.example.hiltcleanarchitecture1.data.remote.response.SearchRepoResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ItemApi {

    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String, @Query("page") page: Int): Single<SearchRepoResponse>
}