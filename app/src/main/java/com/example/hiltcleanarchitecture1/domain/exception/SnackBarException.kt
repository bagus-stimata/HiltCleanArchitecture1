package com.example.hiltcleanarchitecture1.domain.exception

import com.example.cleanarchitecture.domain.annotation.ExceptionType

class SnackBarException(
    override val code: Int,
    override val message: String
) : CleanException(code, ExceptionType.SNACK, message)