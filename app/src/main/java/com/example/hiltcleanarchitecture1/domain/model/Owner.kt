package com.example.hiltcleanarchitecture1.domain.model

import com.example.hiltcleanarchitecture1.domain.base.Model

data class Owner(val id: Int, val login: String?, val avatar: String?) : Model()