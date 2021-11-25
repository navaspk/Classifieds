package com.sample.di.modules


import com.classified.sample.BuildConfig
import com.sample.core.di.scopes.PerApplication
import com.sample.core.domain.remote.GsonProvider
import com.sample.core.domain.remote.NetworkUtil
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    @PerApplication
    fun provideNetworkService(
        gsonProvider: GsonProvider
    ) = NetworkUtil(
        gsonProvider = gsonProvider,
        endPoint = BuildConfig.BASE_URL
    )
}