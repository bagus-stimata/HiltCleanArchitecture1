package com.example.hiltcleanarchitecture1.domain.model

import com.example.hiltcleanarchitecture1.domain.base.Model

data class Contributor(val login: String, val contributions: Int, val avatarUrl: String?) : Model()
