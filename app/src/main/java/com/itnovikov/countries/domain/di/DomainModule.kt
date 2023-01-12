package com.itnovikov.countries.domain.di

import com.itnovikov.countries.data.repository.CountriesRepositoryImpl
import com.itnovikov.countries.domain.repository.CountriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: CountriesRepositoryImpl) : CountriesRepository
}