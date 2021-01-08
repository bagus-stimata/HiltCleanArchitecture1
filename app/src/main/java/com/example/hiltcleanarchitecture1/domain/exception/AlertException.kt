package com.example.hiltcleanarchitecture1.domain.exception

import com.example.cleanarchitecture.domain.annotation.ExceptionType

class AlertException(
    override val code: Int,
    override val message: String,
    val title: String? = null
) : CleanException(code, ExceptionType.ALERT, message)