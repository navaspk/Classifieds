package com.sample.core.domain.rxcallback

import com.sample.core.domain.remote.BaseError

interface OptimizedResponseCallBack<T> {
    fun onApiSuccess(response: T)
    fun onApiError(error: BaseError)
}
