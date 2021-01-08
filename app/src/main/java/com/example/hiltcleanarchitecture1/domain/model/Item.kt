package com.example.hiltcleanarchitecture1.domain.model

import com.example.hiltcleanarchitecture1.domain.base.Model

data class Item(
    val id: Int,
    val name: String?,
    val fullName: String?,
    val description: String?,
    val url: String?,
    val stars: Int?,
    val owner: Owner?
) : Model()
