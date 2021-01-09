package com.example.hiltcleanarchitecture1.domain.usecase.note

import com.example.hiltcleanarchitecture1.domain.exception.AlertException
import com.example.hiltcleanarchitecture1.domain.model.Note
import com.example.hiltcleanarchitecture1.domain.repository.NoteRepository
import com.example.hiltcleanarchitecture1.domain.usecase.UseCase
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetNoteOtherUseCase @Inject constructor(
        private val repository: NoteRepository
): UseCase<GetNoteOtherUseCase.Params, Single<Note>>(){

    data class Params(val id: Int, val owner: String)

    override fun createObservable(params: GetNoteOtherUseCase.Params?): Single<Note> {
        return when (params) {
            null -> Single.error(AlertException(code = -1, message = "Params input not null"))
            else -> repository.getById(params.id)
        }
    }


}