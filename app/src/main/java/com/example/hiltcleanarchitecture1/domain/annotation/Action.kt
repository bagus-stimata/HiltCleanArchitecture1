package com.example.hiltcleanarchitecture1.domain.annotation

import androidx.annotation.IntDef
import com.example.hiltcleanarchitecture1.domain.annotation.Action.Companion.CLOSE_SESSION
import com.example.hiltcleanarchitecture1.domain.annotation.Action.Companion.RELOAD_PAGE

@IntDef(RELOAD_PAGE, CLOSE_SESSION)
annotation class Action {
    companion object {
        const val RELOAD_PAGE = 1
        const val CLOSE_SESSION = 2
    }
}