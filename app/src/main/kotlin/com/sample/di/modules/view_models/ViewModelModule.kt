package com.sample.di.modules.view_models

import androidx.lifecycle.ViewModelProvider
import com.sample.viewmodelprovider.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}