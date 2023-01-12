package com.itnovikov.countries.domain.usecases

import com.itnovikov.countries.domain.repository.CountriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(private val repository: CountriesRepository) {

    suspend fun getCountries() = withContext(Dispatchers.IO) { repository.getCountries() }
}