package com.sample.core

import timber.log.Timber

object ClassifiedsLogger {

    init {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }

    fun d(
        tag: String,
        message: String,
        vararg params: Any
    ) = Timber.tag(tag).d(message, params)

    fun i(
        tag: String,
        message: String,
        vararg params: Any
    ) = Timber.tag(tag).i(message, params)

    fun e(
        tag: String,
        message: String,
        vararg params: Any
    ) = Timber.tag(tag).e(message, params)

}
