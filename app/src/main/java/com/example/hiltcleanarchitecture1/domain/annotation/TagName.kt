package com.example.hiltcleanarchitecture1.domain.annotation

import androidx.annotation.StringDef

@StringDef(TagName.PASSWORD_INCORRECT_TAG)
annotation class TagName {
    companion object {
        const val PASSWORD_INCORRECT_TAG = "password_incorrect_tag"
    }
}