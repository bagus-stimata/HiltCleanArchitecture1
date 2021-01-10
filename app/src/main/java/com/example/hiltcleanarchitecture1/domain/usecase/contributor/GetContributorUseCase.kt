package com.example.hiltcleanarchitecture1.domain.usecase.contributor

import com.example.hiltcleanarchitecture1.domain.exception.AlertException
import com.example.hiltcleanarchitecture1.domain.model.Contributor
import com.example.hiltcleanarchitecture1.domain.repository.ContributorRepository
import com.example.hiltcleanarchitecture1.domain.usecase.UseCase
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

open class GetContributorUseCase @Inject constructor(
    private val contributorRepository: ContributorRepository
) : UseCase<GetContributorUseCase.Params, Observable<List<Contributor>>>() {

    override fun createObservable(params: Params?): Observable<List<Contributor>> {
        return when (params) {
            null -> Observable.error(AlertException(code = -1, message = "Params input not null"))
            else -> contributorRepository.getContribution(params.name, params.owner)
        }
    }

    data class Params(val name: String, val owner: String)
}