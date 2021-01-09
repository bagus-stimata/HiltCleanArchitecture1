package com.example.hiltcleanarchitecture1.domain.usecase.note

import com.example.hiltcleanarchitecture1.domain.exception.AlertException
import com.example.hiltcleanarchitecture1.domain.model.Note
import com.example.hiltcleanarchitecture1.domain.repository.NoteRepository
import com.example.hiltcleanarchitecture1.domain.usecase.UseCase
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

open class GetNoteUseCase  @Inject constructor(
        private val repository: NoteRepository
): UseCase<GetNoteUseCase.Params, Observable<List<Note>>>()  {

    data class Params(val name: String)

    override fun createObservable(params: Params?): Observable<List<Note>> {
        return when (params) {
            null -> Observable.error(AlertException(code = -1, message = "Params input not null"))
            else -> repository.getAllData(params.name)
        }
    }
    override fun onCleared() {
    }
}