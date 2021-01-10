package com.example.hiltcleanarchitecture1.domain.model

import com.example.cleanarchitecture.domain.annotation.TagName

data class Tag(@TagName val name: String, val message: String?)