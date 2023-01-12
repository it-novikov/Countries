package com.itnovikov.countries.core.di

import com.itnovikov.countries.core.bases.ResourceProvider
import com.itnovikov.countries.core.remote.NetworkInterceptor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CoreModule {

    @Binds
    abstract fun bindNetworkInterceptor(interceptor: NetworkInterceptor.Impl) : NetworkInterceptor

    @Binds
    abstract fun bindResourceProvider(provider : ResourceProvider.Impl) : ResourceProvider
}