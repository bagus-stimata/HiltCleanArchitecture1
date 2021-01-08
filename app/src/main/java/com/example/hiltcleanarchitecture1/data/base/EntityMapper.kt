package com.example.hiltcleanarchitecture1.data.base

import com.example.hiltcleanarchitecture1.domain.base.Model

interface EntityMapper<M : Model, ME : ModelEntity> {
    fun mapToDomain(entity: ME): M

    fun mapToEntity(model: M): ME
}