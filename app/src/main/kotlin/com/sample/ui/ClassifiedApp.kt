package com.sample.ui

import android.app.Application
import com.sample.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ClassifiedApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    companion object {
        lateinit var instance: ClassifiedApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        DaggerApplicationComponent
            .builder()
            .create(this)
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}
