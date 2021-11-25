package com.sample.ui.main.fragment.details.adapter

import com.classified.sample.databinding.RecyclerDetailsItemContentBinding
import com.sample.base.BaseViewHolder
import com.sample.core.domain.entity.ResultsItem
import com.sample.ui.main.fragment.details.model.SelectedItemModel

/**
 * View holder class with data inflate for item details screen
 */
class DetailItemsHeadingViewHolder(
    private var recyclerItem: RecyclerDetailsItemContentBinding
) : BaseViewHolder<SelectedItemModel>(recyclerItem.root) {

    override fun bindItem(item: SelectedItemModel) {
        recyclerItem.data = item
    }

}

