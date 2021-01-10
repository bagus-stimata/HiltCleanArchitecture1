package com.example.hiltcleanarchitecture1.presentation.base

import com.example.hiltcleanarchitecture1.domain.base.Model


interface ItemMapper<M : Model, MI : ModelItem> {
    fun mapToPresentation(model: M): ModelItem

    fun mapToDomain(modelItem: MI): Model
}