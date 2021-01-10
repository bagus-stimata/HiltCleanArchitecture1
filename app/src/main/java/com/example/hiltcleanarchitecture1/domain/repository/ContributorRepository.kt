package com.example.hiltcleanarchitecture1.domain.repository

import com.example.hiltcleanarchitecture1.domain.model.Contributor
import io.reactivex.rxjava3.core.Observable
import javax.inject.Singleton

@Singleton
interface ContributorRepository {
    // get contributor from a repository on github
    fun getContribution(name: String, owner: String): Observable<List<Contributor>>
}