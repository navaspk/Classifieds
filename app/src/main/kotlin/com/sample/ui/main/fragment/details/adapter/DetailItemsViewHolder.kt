package com.sample.ui.main.fragment.details.adapter

import com.classified.sample.R
import com.classified.sample.databinding.RecyclerDetailsItemDescBinding
import com.sample.base.BaseViewHolder
import com.sample.core.extensions.safeGet
import com.sample.ui.main.fragment.details.model.SelectedItemModel

/**
 * View holder class with data inflate
 */
class DetailItemsViewHolder(
    private var recyclerItem: RecyclerDetailsItemDescBinding
) : BaseViewHolder<SelectedItemModel>(recyclerItem.root) {

    var date = ""
    var time = ""

    override fun bindItem(item: SelectedItemModel) {
        val context = recyclerItem.itemDescription.context
        recyclerItem.itemDescription.text =
            if (item.itemType == ClassifiedItemLayoutType.TYPE_CLASSIFIED_ITEM_DESC.ordinal) {
                getTimeAndDate(item)
                String.format(
                    context.getString(R.string.content_desc),
                    getName(item),
                    getPrice(item),
                    time,
                    date
                )
            } else {
                "${context.getString(R.string.brandName)}   :   ${item.content}"
            }

    }

    private fun getTimeAndDate(item: SelectedItemModel) {
        if (item.content.contains(":")) {
            val content = item.content.split(":")
            if (content.size > 2) {
                if (content[2].contains(" ")) {
                    time = content[2].safeGet().split(" ")[1].safeGet()
                    date = content[2].safeGet().split(" ")[0].safeGet()
                    if (time.length >= 5)
                        time = time.substring(0, 5)
                } else {
                    time = content[2].safeGet()
                    date = ""
                }
            }
        }
    }

    private fun getName(item: SelectedItemModel): String {
        return item.content.contains(":").run {
            val content = item.content.split(":")
            content[0]
        }
    }

    private fun getPrice(item: SelectedItemModel): String {
        return item.content.contains(":").run {
            val content = item.content.split(":")
            content[1]
        }
    }

}
