package com.sample.di.modules

import com.sample.core.di.scopes.PerActivity
import com.sample.ui.main.activities.MainActivity
import com.sample.di.modules.view_models.MainActivityModule
import com.sample.ui.splash.SplashActivity
import com.sample.di.modules.view_models.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun contributeSplashActivity() : SplashActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity() : MainActivity

}