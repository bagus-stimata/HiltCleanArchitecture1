package com.example.hiltcleanarchitecture1.presentation

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.hiltcleanarchitecture1.data.repository.NoteRepositoryImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel @ViewModelInject constructor(private val noteRepository: NoteRepositoryImpl) : ViewModel(){

    fun saveNote(content: String) {
        println("## Save Note Start")

        Observable.just(content)
            .observeOn(Schedulers.io())
            .map { str -> str }
            .doOnNext {
                noteRepository.saveNote(it)
                Log.d("result", "Saved Bos")
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {},
                {},
                {}
            )
        println("## Save Note Stop")

    }

    fun saveCharacter(content: String) {
        println("## Save Note Start")

        Observable.just(content)
            .observeOn(Schedulers.io())
            .map { str -> str }
            .doOnNext {
                noteRepository.saveNote(it)
                Log.d("result", "Saved Bos")
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {},
                {},
                {}
            )
        println("## Save Note Stop")

    }

}