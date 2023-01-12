package com.itnovikov.countries.core.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavOptions

interface CountriesNavigator {

    fun navigateTo(
        @IdRes resId: Int,
        args: Bundle?,
        navOptions: NavOptions?,
    )

    fun navigateTo(
        @IdRes resId: Int,
    )

    fun navigateTo(
        @IdRes resId: Int,
        args: Bundle?,
    )

    fun navigateUp()
}