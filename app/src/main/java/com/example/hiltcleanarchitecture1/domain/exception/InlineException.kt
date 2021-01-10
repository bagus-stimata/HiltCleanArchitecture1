package com.example.hiltcleanarchitecture1.domain.exception

import com.example.cleanarchitecture.domain.annotation.ExceptionType
import com.example.hiltcleanarchitecture1.domain.model.Tag

class InlineException(
    override val code: Int,
    vararg val tags: Tag
) : CleanException(code, ExceptionType.INLINE, null)