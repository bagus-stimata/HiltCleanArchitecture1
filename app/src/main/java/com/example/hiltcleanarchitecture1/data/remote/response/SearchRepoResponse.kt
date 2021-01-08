package com.example.hiltcleanarchitecture1.data.remote.response

import com.example.hiltcleanarchitecture1.data.local.entity.ItemEntity
import com.google.gson.annotations.SerializedName

data class SearchRepoResponse(
    @SerializedName("total_count") val total: Int = 0,
    @SerializedName("items") val items: List<ItemEntity>
)