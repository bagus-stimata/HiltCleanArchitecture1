package com.example.hiltcleanarchitecture1.presentation.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.example.hiltcleanarchitecture1.domain.exception.*
import com.example.hiltcleanarchitecture1.domain.model.Dialog
import com.example.hiltcleanarchitecture1.domain.model.Redirect
import com.example.hiltcleanarchitecture1.domain.model.Tag
import com.example.hiltcleanarchitecture1.domain.usecase.UseCase
import com.example.hiltcleanarchitecture1.presentation.utils.SingleLiveData
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel constructor(
    private vararg val useCases: UseCase<*, *>?
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val snackBarMessage = SingleLiveData<String>()
    val toastMessage = SingleLiveData<String>()
    val inlineException = SingleLiveData<List<Tag>>()
    val alertException = SingleLiveData<Pair<String?, String>>()
    val dialogException = SingleLiveData<Dialog>()
    val redirectException = SingleLiveData<Redirect>()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }


    fun setThrowable(throwable: Throwable) {
        when (throwable) {
            is SnackBarException -> snackBarMessage.value = throwable.message
            is ToastException -> toastMessage.value = throwable.message
            is InlineException -> inlineException.value = throwable.tags.toList()
            is AlertException -> alertException.value = Pair(throwable.title, throwable.message)
            is DialogException -> dialogException.value = throwable.dialog
            is RedirectException -> redirectException.value = throwable.redirect
        }
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        useCases.let { userCases ->
            if (userCases.isNotEmpty()) userCases.forEach { it?.onCleared() }
        }
        super.onCleared()
    }
}
