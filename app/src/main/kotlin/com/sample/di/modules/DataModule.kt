package com.sample.di.modules

import com.sample.core.di.scopes.PerApplication
import com.sample.core.domain.executor.PostExecutionThread
import com.sample.core.domain.remote.GsonProvider
import com.sample.core.domain.repository.GetAllItemRepository
import com.sample.core.domain.repository.impl.GetAllItemRepositoryImpl
import com.sample.di.threadhelper.UiThread
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DataModule {

    @Module
    companion object {
        @PerApplication
        @Provides
        @JvmStatic
        fun provideGson(): GsonProvider = GsonProvider()
    }

    @PerApplication
    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @PerApplication
    @Binds
    abstract fun bindGetAllItemRepository(getAllItemRepository: GetAllItemRepositoryImpl): GetAllItemRepository

}