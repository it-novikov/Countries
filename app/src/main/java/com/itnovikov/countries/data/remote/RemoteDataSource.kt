package com.itnovikov.countries.data.remote

import com.itnovikov.countries.core.bases.BaseResult
import com.itnovikov.countries.core.remote.Failure
import com.itnovikov.countries.core.remote.NoInternetConnectionException
import com.itnovikov.countries.data.remote.response.ResponseCountry
import com.itnovikov.countries.domain.model.CountryDomain
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: CountriesService,
    private val mapper: CountryDataToDomainMapper
) {

    suspend fun getResultRequestCountry() : BaseResult<List<CountryDomain>, Failure> {
        return try {
            val response: Response<List<ResponseCountry>> = api.getCountries()

            if (response.isSuccessful) {

                val body: List<ResponseCountry>? = response.body()

                BaseResult.Success(body!!.map { mapper.map(it) })
            } else {
                BaseResult.Error(Failure(response.code(), response.message()))
            }
        } catch (e: NoInternetConnectionException) {
            BaseResult.Error(Failure(0, e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            BaseResult.Error(Failure(-1, e.message.toString()))
        }
    }
}