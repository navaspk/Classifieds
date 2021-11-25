package com.sample.di.modules.view_models

import androidx.lifecycle.ViewModel
import com.sample.di.key.ViewModelKey
import com.sample.ui.splash.SplashActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SplashActivityViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashActivityViewModel::class)
    fun bindSplashActivityViewModel(viewModel: SplashActivityViewModel): ViewModel

}