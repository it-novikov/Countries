package com.itnovikov.countries.data.di

import com.itnovikov.countries.data.remote.CountriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideCountriesService(retrofit: Retrofit): CountriesService =
        retrofit.create(CountriesService::class.java)
}