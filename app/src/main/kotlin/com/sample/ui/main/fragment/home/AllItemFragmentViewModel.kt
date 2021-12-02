package com.sample.ui.main.fragment.home

import androidx.lifecycle.MutableLiveData
import com.sample.base.BaseViewModel
import com.sample.core.domain.entity.ItemsResponse
import com.sample.core.domain.entity.ResultsItem
import com.sample.core.domain.remote.BaseError
import com.sample.core.domain.rxcallback.OptimizedCallbackWrapper
import com.sample.core.domain.usecase.GetAllItemUseCase
import javax.inject.Inject

/**
 * View model class responsible for performing ultimate logic & get back the response
 */
class AllItemFragmentViewModel @Inject constructor(
    private val allItemUseCase: GetAllItemUseCase
) : BaseViewModel<AllItemFragmentNavigator>() {

    // region VARIABLE
    var itemLiveDat = MutableLiveData<ArrayList<ResultsItem>>()
    // endregion

    fun getAllClassifiedContents() {
        addDisposable(
            allItemUseCase.execute(
                ClassifiedsSubscriber()
            )
        )
    }

    inner class ClassifiedsSubscriber : OptimizedCallbackWrapper<ItemsResponse>() {

        override fun onApiSuccess(response: ItemsResponse) {
            if (response.status || response.results?.isNotEmpty() == true) {
                itemLiveDat.postValue(response.results as ArrayList<ResultsItem>)
            } else {
                getNavigator()?.somethingWentWrong()
            }
        }

        override fun onApiError(error: BaseError) {
            getNavigator()?.somethingWentWrong()
        }

    }
}
