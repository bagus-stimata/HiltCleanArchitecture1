package com.example.hiltcleanarchitecture1.presentation.ui.test

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

//class BlankViewModel  @Inject constructor(
//    private val searchItemUseCase: SearchItemUseCase,
//    private val repoItemMapper: RepoItemMapper
//)  : BaseViewModel() {

//class BlankViewModel  @ViewModelInject constructor(private val repoItemMapper: RepoItemMapper
//)  : BaseViewModel() {

class BlankViewModel  @ViewModelInject constructor(private val repoItemMapper: MyRepoItemMapper
):ViewModel()  {

//    val data = MutableLiveData<List<RepoItem>>()
//    val query = MutableLiveData<String>()
//    val loading = MutableLiveData<Boolean>().apply { postValue(false) }



    fun testAja() {
        println("Test aja")
    }



//    fun searchRepo() = when (query.value.isNullOrEmpty()) {
//        true -> Unit
//        false -> query.value?.let {
//            searchItemUseCase.createObservable(SearchItemUseCase.Params(query = it, pageNumber = 1))
//                .compose(RxUtils.applySingleScheduler(loading))
//                .doFinally { loading.value = false }
//                .map { it.map { repoItemMapper.mapToPresentation(it) } }
//                .subscribe({ data.value = it }, {
//                    Timber.e("Get repo error: $it")
//                    setThrowable(it)
//                })
//                .add(this)
//        }
//    }

//    @VisibleForTesting
//    fun clear() {
//        super.onCleared()
//    }

}

class MyRepoItemMapper @Inject constructor(){

    fun doAThing(): String{
        return "result: Repo Item Mapper Ini"
    }
}

//@InstallIn(SingletonComponent::class)
//@Module
//class MyModule{
//
//    @Singleton
//    @Provides
//    fun provideMyRepo(): MyRepoItemMapper {
//        return MyRepoItemMapper()
//    }
//}