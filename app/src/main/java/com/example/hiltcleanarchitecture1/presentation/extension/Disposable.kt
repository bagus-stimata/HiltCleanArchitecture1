package com.example.hiltcleanarchitecture1.presentation.extension

import com.example.hiltcleanarchitecture1.presentation.base.BaseViewModel
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.add(viewModel: BaseViewModel) {
    viewModel.addDisposable(this)
}