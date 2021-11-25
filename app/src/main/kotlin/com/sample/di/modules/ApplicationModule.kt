package com.sample.di.modules

import android.content.Context
import com.sample.core.di.qualifier.ApplicationContext
import com.sample.core.di.scopes.PerApplication
import com.sample.ui.ClassifiedApp
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @ApplicationContext
    @PerApplication
    @Binds
    abstract fun bindApplication(application: ClassifiedApp) : Context
}