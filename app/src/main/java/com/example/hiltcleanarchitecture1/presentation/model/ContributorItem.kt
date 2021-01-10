package com.example.hiltcleanarchitecture1.presentation.model

import com.example.hiltcleanarchitecture1.domain.model.Contributor
import com.example.hiltcleanarchitecture1.presentation.base.ItemMapper
import com.example.hiltcleanarchitecture1.presentation.base.ModelItem
import javax.inject.Inject

data class ContributorItem(
    val login: String,
    val contributions: Int,
    val avatarUrl: String?
) : ModelItem()

class ContributorItemMapper @Inject constructor() : ItemMapper<Contributor, ContributorItem> {

    override fun mapToDomain(modelItem: ContributorItem) = Contributor(
        modelItem.login, modelItem.contributions, modelItem.avatarUrl
    )

    override fun mapToPresentation(model: Contributor) = ContributorItem(
        model.login, model.contributions, model.avatarUrl
    )
}
