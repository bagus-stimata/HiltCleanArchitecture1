package com.example.hiltcleanarchitecture1.domain.model

import com.example.hiltcleanarchitecture1.domain.base.Model

data class Note(val id: Int,
                val content: String) : Model()
