package com.example.hiltcleanarchitecture1.domain.annotation

import androidx.annotation.IntDef

@IntDef(Redirect.OPEN_HOME_SCREEN)
annotation class Redirect {
    companion object {
        const val OPEN_HOME_SCREEN = 1
    }
}