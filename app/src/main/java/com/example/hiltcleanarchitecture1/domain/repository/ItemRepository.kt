package com.example.hiltcleanarchitecture1.domain.repository

import com.example.hiltcleanarchitecture1.domain.model.Item
import io.reactivex.rxjava3.core.Single

interface ItemRepository : Repository {
    fun getItem(id: Int): Single<Item>

    fun searchItems(query: String, page: Int? = 1): Single<List<Item>>
}