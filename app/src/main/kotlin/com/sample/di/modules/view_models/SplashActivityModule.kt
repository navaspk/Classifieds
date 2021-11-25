package com.sample.di.modules.view_models

import com.sample.core.di.scopes.PerActivity
import com.sample.di.modules.ActivityModule
import com.sample.ui.splash.SplashActivity
import dagger.Binds
import dagger.Module

@Module(includes = [ActivityModule::class])
abstract class SplashActivityModule {

    @PerActivity
    @Binds
    abstract fun bindSplashActivity(activity: SplashActivity): SplashActivity

}