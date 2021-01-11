package com.example.hiltcleanarchitecture1.domain.exception

import com.example.hiltcleanarchitecture1.domain.annotation.ExceptionType
import com.example.hiltcleanarchitecture1.domain.model.Dialog

class DialogException(
    override val code: Int,
    val dialog: Dialog
) : CleanException(code, ExceptionType.DIALOG, null)