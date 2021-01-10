package com.example.hiltcleanarchitecture1.domain.usecase.item

import com.example.hiltcleanarchitecture1.domain.model.Item
import com.example.hiltcleanarchitecture1.domain.repository.ItemRepository
import com.example.hiltcleanarchitecture1.domain.usecase.UseCase
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

open class SearchItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) : UseCase<SearchItemUseCase.Params, Single<List<Item>>>() {
    override fun createObservable(params: Params?): Single<List<Item>> {
        params?.let { return itemRepository.searchItems(query = params.query, page = params.pageNumber) }

        return Single.error(Throwable(""))
    }

    override fun onCleared() {
    }

    data class Params(val query: String, val pageNumber: Int? = 1)
}