package com.sample.core.domain.usecase

import com.sample.core.domain.SingleUseCase
import com.sample.core.domain.entity.ItemsResponse
import com.sample.core.domain.executor.PostExecutionThread
import com.sample.core.domain.repository.GetAllItemRepository
import io.reactivex.Single
import javax.inject.Inject

class GetAllItemUseCase @Inject constructor(
    private val getItemRepository: GetAllItemRepository,
    private val postExecutionThread: PostExecutionThread
) : SingleUseCase<ItemsResponse, GetAllItemUseCase.Params>(
    postExecutionThread
) {

    override fun buildUseCase(params: Params?): Single<ItemsResponse> {
        android.util.Log.d("mine","buildUseCase nd calling to api getClassifiedItems")
        return getItemRepository.getClassifiedItems()
    }

    data class Params constructor(
        val request: String = ""
    )

}
