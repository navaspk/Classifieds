package com.sample.ui.main.fragment.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.classified.sample.databinding.RecyclerDetailsItemContentBinding
import com.classified.sample.databinding.RecyclerDetailsItemDescBinding
import com.sample.base.BaseRecyclerAdapter
import com.sample.base.BaseViewHolder
import com.sample.base.ItemClickListener
import com.sample.ui.main.fragment.details.model.SelectedItemModel

/**
 * Adapter with view holder instantiation
 */
class DetailItemAdapter(
    itemClickListener: ItemClickListener
) : BaseRecyclerAdapter<SelectedItemModel>(itemClickListener) {

    override fun getItemViewType(position: Int): Int {
        return getItems()[position].itemType
    }

    override fun createBaseViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<SelectedItemModel> {
        return when (viewType) {
            ClassifiedItemLayoutType.TYPE_CLASSIFIED_ITEM_BRAND.ordinal,
            ClassifiedItemLayoutType.TYPE_CLASSIFIED_ITEM_DESC.ordinal -> {
                DetailItemsViewHolder(
                    RecyclerDetailsItemDescBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            ClassifiedItemLayoutType.TYPE_CLASSIFIED_ITEM_HEADING.ordinal -> {
                DetailItemsHeadingViewHolder(
                    RecyclerDetailsItemContentBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }

            else -> {
                throw IllegalStateException("Invalid view type")
            }
        }
    }

}
