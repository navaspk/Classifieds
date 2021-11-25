package com.sample.ui.splash

import com.sample.base.BaseNavigator
import com.sample.base.BaseViewModel
import javax.inject.Inject

/**
 * To perform operation for splash screen in case any beginning operation need to be perform in future
 */
class SplashActivityViewModel @Inject constructor() : BaseViewModel<BaseNavigator>() {

    object Constants {
        const val SPLASH_DELAY: Long = 5_00
    }
}
