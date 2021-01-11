package com.example.hiltcleanarchitecture1.domain.exception

import com.example.hiltcleanarchitecture1.domain.annotation.ExceptionType

class AlertException(
    override val code: Int,
    override val message: String,
    val title: String? = null
) : CleanException(code, ExceptionType.ALERT, message)