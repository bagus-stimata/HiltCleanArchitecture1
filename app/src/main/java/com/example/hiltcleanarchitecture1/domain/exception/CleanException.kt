package com.example.hiltcleanarchitecture1.domain.exception

import com.example.hiltcleanarchitecture1.domain.annotation.ExceptionType

open class CleanException(
    open val code: Int,
    @ExceptionType val exceptionType: Int,
    override val message: String?
) : Throwable(message)