package com.itnovikov.countries.domain.repository

import com.itnovikov.countries.core.bases.BaseResult
import com.itnovikov.countries.core.remote.Failure
import com.itnovikov.countries.domain.model.CountryDomain

interface CountriesRepository {
    suspend fun getCountries(): BaseResult<List<CountryDomain>, Failure>
}