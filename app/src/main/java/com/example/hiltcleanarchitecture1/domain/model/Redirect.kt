package com.example.hiltcleanarchitecture1.domain.model

import com.example.cleanarchitecture.domain.annotation.Redirect

data class Redirect(@Redirect val redirect: Int, val redirectObject: Any? = null)