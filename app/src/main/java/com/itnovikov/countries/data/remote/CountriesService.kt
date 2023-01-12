package com.itnovikov.countries.data.remote

import com.itnovikov.countries.data.remote.response.ResponseCountry
import retrofit2.Response
import retrofit2.http.GET

interface CountriesService {
    @GET("v2/all")
    suspend fun getCountries() : Response<List<ResponseCountry>>
}