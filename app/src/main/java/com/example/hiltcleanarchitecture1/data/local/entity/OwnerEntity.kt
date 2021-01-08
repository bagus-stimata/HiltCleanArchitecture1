package com.example.hiltcleanarchitecture1.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hiltcleanarchitecture1.Constants
import com.example.hiltcleanarchitecture1.data.base.EntityMapper
import com.example.hiltcleanarchitecture1.data.base.ModelEntity
import com.example.hiltcleanarchitecture1.domain.model.Owner
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

@Entity(
        tableName = Constants.Table.OWNER
)
data class OwnerEntity(
        @PrimaryKey val id: Int=0,
        val login: String?,
        val avatar: String?
) : ModelEntity()

class OwnerEntityMapper @Inject constructor() : EntityMapper<Owner, OwnerEntity> {
    override fun mapToDomain(entity: OwnerEntity) = Owner(
        entity.id, entity.login, entity.avatar
    )

    override fun mapToEntity(model: Owner) = OwnerEntity(
        model.id, model.login, model.avatar
    )
}