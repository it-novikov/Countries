package com.itnovikov.countries.core.bases

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface ResourceProvider {

    fun string(@StringRes id: Int): String

    class Impl @Inject constructor(@ApplicationContext private val context: Context) :
        ResourceProvider {

        override fun string(@StringRes id: Int): String = context.getString(id)
    }
}