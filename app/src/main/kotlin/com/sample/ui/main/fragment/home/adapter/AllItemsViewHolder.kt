package com.sample.ui.main.fragment.home.adapter

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.classified.sample.R
import com.classified.sample.databinding.RecyclerItemHomeBinding
import com.sample.base.BaseViewHolder
import com.sample.core.domain.entity.ResultsItem

/**
 * View holder class with data inflate
 */
class AllItemsViewHolder(
    private var recyclerItem: RecyclerItemHomeBinding
) : BaseViewHolder<ResultsItem>(recyclerItem.root) {

    override fun bindItem(item: ResultsItem) {
        recyclerItem.data = item
        val thumbUrl = item.imageUrlsThumbnails?.get(0)
        if (thumbUrl.isNullOrEmpty().not())
            Glide.with(recyclerItem.itemImage.context)
                .load(thumbUrl)
                .error(R.drawable.classified_logo)
                .placeholder(R.drawable.classified_logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(recyclerItem.itemImage)

        val date = item.createdAt?.split(" ")
        recyclerItem.itemDate.text = date?.get(0) ?: ""
    }

}

