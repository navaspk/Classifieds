package com.sample.di.threadhelper

import com.sample.core.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class UiThread @Inject constructor() : PostExecutionThread {
    override fun scheduler(): Scheduler = AndroidSchedulers.mainThread()
}