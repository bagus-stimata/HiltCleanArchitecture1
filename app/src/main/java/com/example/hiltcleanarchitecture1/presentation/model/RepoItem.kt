package com.example.hiltcleanarchitecture1.presentation.model

import android.os.Parcelable
import com.example.hiltcleanarchitecture1.domain.model.Item
import com.example.hiltcleanarchitecture1.presentation.base.ItemMapper
import com.example.hiltcleanarchitecture1.presentation.base.ModelItem
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject

@Parcelize
data class RepoItem(
    val id: Int,
    val name: String?,
    val fullName: String?,
    val description: String?,
    val url: String?,
    val stars: String,
    val ownerItem: OwnerItem?
) : ModelItem(), Parcelable

//class RepoItemMapper @Inject constructor(
//    private val ownerItemMapper: OwnerItemMapper
//) : ItemMapper<Item, RepoItem> {

class RepoItemMapper @Inject constructor() {

//    override fun mapToPresentation(model: Item) = RepoItem(
//        id = model.id,
//        name = model.name,
//        fullName = model.fullName,
//        description = model.description,
//        url = model.url,
//        stars = (model.stars ?: 0).toString(),
//        ownerItem = model.owner?.let { ownerItemMapper.mapToPresentation(it) }
//    )
//
//    override fun mapToDomain(modelItem: RepoItem) = Item(
//        id = modelItem.id,
//        name = modelItem.name,
//        fullName = modelItem.fullName,
//        description = modelItem.description,
//        url = modelItem.url,
//        stars = modelItem.stars.toIntOrNull(),
//        owner = modelItem.ownerItem?.let { ownerItemMapper.mapToDomain(it) }
//    )

}