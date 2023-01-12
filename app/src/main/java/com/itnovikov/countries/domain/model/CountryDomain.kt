package com.itnovikov.countries.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryDomain(
    val countryName: String? = null,
    val region: String? = null,
    val flag: String? = null,
    val capital: String? = null,
    val currenciesName: List<String?>? = null,
    val listTimeZone: List<String?>? = null
) : Parcelable