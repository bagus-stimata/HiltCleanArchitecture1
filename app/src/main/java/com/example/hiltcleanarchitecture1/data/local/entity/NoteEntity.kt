package com.example.hiltcleanarchitecture1.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hiltcleanarchitecture1.Constants
import com.example.hiltcleanarchitecture1.data.base.EntityMapper
import com.example.hiltcleanarchitecture1.data.base.ModelEntity
import com.example.hiltcleanarchitecture1.domain.model.Note
import javax.inject.Inject


/**
 * Created by wisnu on 8/7/18
 */
@Entity(
    tableName = Constants.Table.NOTE
)
data class NoteEntity(
            @PrimaryKey val id: Int,
            val content: String) : ModelEntity()

class NoteEntityMapper @Inject constructor() : EntityMapper<Note, NoteEntity> {
    override fun mapToDomain(entity: NoteEntity): Note = Note(
        id = entity.id,
        content = entity.content
    )

    override fun mapToEntity(model: Note): NoteEntity = NoteEntity(
        id = model.id,
        content = model.content
    )
}
