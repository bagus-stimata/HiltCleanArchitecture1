package com.example.hiltcleanarchitecture1.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hiltcleanarchitecture1.Constants
import com.example.hiltcleanarchitecture1.data.base.EntityMapper
import com.example.hiltcleanarchitecture1.data.base.ModelEntity
import javax.inject.Inject
import com.example.hiltcleanarchitecture1.domain.model.Character

@Entity(
    tableName = Constants.Table.CHARACTER
)
data class CharacterEntity(
    val created: String,
    val gender: String,
    @PrimaryKey
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) : ModelEntity()

class CharacterEntityMapper @Inject constructor() : EntityMapper<Character, CharacterEntity> {
    override fun mapToDomain(entity: CharacterEntity): Character = Character(
        created = entity.created,
        gender = entity.gender,
        id = entity.id,
        image = entity.image,
        name = entity.name,
        species = entity.species,
        status = entity.status,
        type = entity.type,
        url = entity.url
    )

    override fun mapToEntity(model: Character): CharacterEntity = CharacterEntity(
        created = model.created,
        gender = model.gender,
        id = model.id,
        image = model.image,
        name = model.name,
        species = model.species,
        status = model.status,
        type = model.type,
        url = model.url
    )
}
