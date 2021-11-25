package com.sample.core.domain.entity

import com.google.gson.annotations.SerializedName
import com.sample.core.domain.remote.BaseResponse

data class ItemsResponse(

    @field:SerializedName("pagination")
    val pagination: Pagination? = null,

    @field:SerializedName("results")
    val results: List<ResultsItem>? = null

): BaseResponse()

data class Pagination(

    @field:SerializedName("key")
    val key: Any? = null
)

data class ResultsItem(

    @field:SerializedName("uid")
    val uid: String? = null,

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("image_ids")
    val imageIds: List<String?>? = null,

    @field:SerializedName("image_urls")
    val imageUrls: List<String?>? = null,

    @field:SerializedName("image_urls_thumbnails")
    val imageUrlsThumbnails: List<String?>? = null
)
