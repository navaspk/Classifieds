package com.sample.ui.main.fragment.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.classified.sample.databinding.RecyclerItemHomeBinding
import com.sample.base.BaseRecyclerAdapter
import com.sample.base.BaseViewHolder
import com.sample.base.ItemClickListener
import com.sample.core.domain.entity.ResultsItem

/**
 * Adapter with view holder instantiation
 */
class AllItemsAdapter(
    itemClickListener: ItemClickListener
) : BaseRecyclerAdapter<ResultsItem>(itemClickListener) {

    override fun createBaseViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ResultsItem> {
        return AllItemsViewHolder(
            RecyclerItemHomeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

}
