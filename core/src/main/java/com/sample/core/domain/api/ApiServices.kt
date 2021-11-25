package com.sample.core.domain.api

import com.sample.core.domain.entity.ItemsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiServices {

    @GET("default/dynamodb-writer")
    fun getAllItemToShow(): Single<ItemsResponse>

}
