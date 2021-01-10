package com.example.hiltcleanarchitecture1.domain.exception

import com.example.cleanarchitecture.domain.annotation.ExceptionType
import com.example.hiltcleanarchitecture1.domain.model.Redirect

class RedirectException(
    override val code: Int,
    val redirect: Redirect
) : CleanException(code, ExceptionType.REDIRECT, null)