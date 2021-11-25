package com.sample.di.modules

import com.sample.core.di.scopes.PerApplication
import com.sample.core.domain.remote.NetworkUtil
import com.sample.core.domain.api.ApiServices
import dagger.Module
import dagger.Provides

@Module
class RemoteModule {

    @Module
    companion object {

        @PerApplication
        @Provides
        @JvmStatic
        fun provideApiService(networkUtil: NetworkUtil) =
            networkUtil.create(ApiServices::class.java)

    }

}