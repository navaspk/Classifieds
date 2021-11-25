package com.sample.di.component

import com.sample.core.di.scopes.PerApplication
import com.sample.di.modules.*
import com.sample.di.modules.view_models.*
import com.sample.ui.ClassifiedApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        ApplicationModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        DataModule::class,
        RemoteModule::class,
        MainActivityViewModelModule::class,
        SplashActivityViewModelModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<ClassifiedApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ClassifiedApp>()
}