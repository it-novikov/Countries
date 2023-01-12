package com.itnovikov.countries.data.remote

import com.itnovikov.countries.core.bases.Mapper
import com.itnovikov.countries.data.remote.response.ResponseCountry
import com.itnovikov.countries.domain.model.CountryDomain
import javax.inject.Inject

class CountryDataToDomainMapper @Inject constructor() : Mapper<ResponseCountry, CountryDomain> {

    override fun map(data: ResponseCountry): CountryDomain {
        return CountryDomain(
            countryName = data.name,
            region = data.region,
            flag = data.flags?.png,
            capital = data.capital,
            currenciesName = data.currencies?.map { it?.name },
            listTimeZone = data.timezones?.map { it }
        )
    }
}