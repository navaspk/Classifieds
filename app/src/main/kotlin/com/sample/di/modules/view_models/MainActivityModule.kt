package com.sample.di.modules.view_models

import com.sample.core.di.scopes.PerActivity
import com.sample.core.di.scopes.PerFragment
import com.sample.di.modules.ActivityModule
import com.sample.ui.main.activities.MainActivity
import com.sample.ui.main.fragment.home.AllItemFragment
import com.sample.ui.main.fragment.details.ItemDetailsFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ActivityModule::class])
abstract class MainActivityModule {

    @PerActivity
    @Binds
    abstract fun bindMainActivity(mainActivity: MainActivity): MainActivity

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindAllItemFragment(): AllItemFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun bindItemDetailsFragment(): ItemDetailsFragment

}