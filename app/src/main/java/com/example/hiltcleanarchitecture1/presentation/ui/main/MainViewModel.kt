package com.example.hiltcleanarchitecture1.presentation.ui.main

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import com.example.hiltcleanarchitecture1.domain.usecase.item.SearchItemUseCase
import com.example.hiltcleanarchitecture1.presentation.base.BaseViewModel
import com.example.hiltcleanarchitecture1.presentation.extension.add
import com.example.hiltcleanarchitecture1.presentation.model.RepoItem
import com.example.hiltcleanarchitecture1.presentation.model.RepoItemMapper
import com.example.hiltcleanarchitecture1.presentation.utils.RxUtils
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val searchItemUseCase: SearchItemUseCase,
    private val repoItemMapper: RepoItemMapper
) : BaseViewModel() {


    val data = MutableLiveData<List<RepoItem>>()
    val query = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>().apply { postValue(false) }

    fun searchRepo() = when (query.value.isNullOrEmpty()) {

        true -> Unit
        false -> query.value?.let {
            searchItemUseCase.createObservable(SearchItemUseCase.Params(query = it, pageNumber = 1))
                .compose(RxUtils.applySingleScheduler(loading))
                .doFinally { loading.value = false }
                .map { it.map { repoItemMapper.mapToPresentation(it) } }
                .subscribe({ data.value = it }, {
                    Timber.e("Get repo error: $it")
                    setThrowable(it)
                })
                .add(this)
        }
    }

    @VisibleForTesting
    fun clear() {
        super.onCleared()
    }
}