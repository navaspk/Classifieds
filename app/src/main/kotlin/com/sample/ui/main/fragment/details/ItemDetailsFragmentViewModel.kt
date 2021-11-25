package com.sample.ui.main.fragment.details

import androidx.lifecycle.viewModelScope
import com.sample.base.BaseNavigator
import com.sample.base.BaseViewModel
import com.sample.core.domain.entity.ResultsItem
import com.sample.core.extensions.safeGet
import com.sample.ui.main.fragment.details.adapter.ClassifiedItemLayoutType
import com.sample.ui.main.fragment.details.model.SelectedItemModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * View model class for detail fragment to perform their own task
 */
class ItemDetailsFragmentViewModel @Inject constructor() : BaseViewModel<BaseNavigator>() {

    fun getListOfDataForDetailScreen(
        resultsItem: ResultsItem,
        action: (ArrayList<SelectedItemModel>) -> Unit
    ) {

        viewModelScope.launch {
            val deferredItem = viewModelScope.async {
                getList(resultsItem)
            }

            action.invoke(deferredItem.await())
        }
    }

    private fun getList(resultsItem: ResultsItem): ArrayList<SelectedItemModel> {
        val items = ArrayList<SelectedItemModel>()
        return items.apply {
            add(
                SelectedItemModel(
                    content = resultsItem.name.safeGet(),
                    itemType = ClassifiedItemLayoutType.TYPE_CLASSIFIED_ITEM_HEADING.ordinal
                )
            )

            add(
                SelectedItemModel(
                    ClassifiedItemLayoutType.TYPE_CLASSIFIED_ITEM_DESC.ordinal,
                    "${resultsItem.name.safeGet()}:${resultsItem.price}:${resultsItem.createdAt}"
                )
            )

            add(
                SelectedItemModel(
                    ClassifiedItemLayoutType.TYPE_CLASSIFIED_ITEM_BRAND.ordinal,
                    "Well Known"
                )
            )
        }
    }
}