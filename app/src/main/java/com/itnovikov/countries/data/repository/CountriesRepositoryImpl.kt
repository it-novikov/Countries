package com.itnovikov.countries.data.repository

import com.itnovikov.countries.core.bases.BaseResult
import com.itnovikov.countries.core.remote.Failure
import com.itnovikov.countries.data.remote.RemoteDataSource
import com.itnovikov.countries.domain.model.CountryDomain
import com.itnovikov.countries.domain.repository.CountriesRepository
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    CountriesRepository {

    override suspend fun getCountries(): BaseResult<List<CountryDomain>, Failure> =
        remoteDataSource.getResultRequestCountry()
}