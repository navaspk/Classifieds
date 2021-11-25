package com.sample.ui.main.fragment.details

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.classified.sample.R
import com.classified.sample.databinding.FragmentDetailsItemExpandBinding
import com.sample.base.BaseFragment
import com.sample.base.ItemClickListener
import com.sample.core.extensions.safeGet
import com.sample.ui.main.activities.MainActivity
import com.sample.ui.main.activities.MainActivityViewModel
import com.sample.ui.main.fragment.details.adapter.DetailItemAdapter

/**
 * Selected detail fragment to show more detail about the product. For no
 */
class ItemDetailsFragment :
    BaseFragment<FragmentDetailsItemExpandBinding, ItemDetailsFragmentViewModel>(),
    ItemClickListener {

    // region VARIABLE
    lateinit var sharedViewModel: MainActivityViewModel
    private var adapter: DetailItemAdapter? = null

    override val viewModel = ItemDetailsFragmentViewModel::class.java
    override fun getBindingVariable() = BR._all
    override val layoutId = R.layout.fragment_details_item_expand
    // endregion

    // region LIFECYCLE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as? MainActivity)?.controlMainToolBarVisibility(View.GONE)
        adapter = DetailItemAdapter(this)
    }

    override fun initUserInterface(view: View?) {
        activity?.run {
            sharedViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        }
        initRecyclerView()
        android.util.Log.d(
            "mine",
            "inituserinterface, sharedViewModel=${sharedViewModel.selectedItem?.name}"
        )

        sharedViewModel.selectedItem?.let { it ->
            viewDataBinding?.let { view ->
                val thumbUrl = it.imageUrls?.get(0)
                if (thumbUrl.isNullOrEmpty().not())
                    activity?.run {
                        Glide.with(this)
                            .load(thumbUrl)
                            .error(R.drawable.classified_logo)
                            .placeholder(R.drawable.classified_logo)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(viewDataBinding?.expandedImage!!)
                    }

                view.textViewPrice.text = it.price

                val name = if (it.name?.contains(",") == true)
                    it.name.safeGet().split(",")[0]
                else it.name
                view.textViewProductName.text = name

            }

            injectedViewModel.getListOfDataForDetailScreen(it) { list ->
                adapter?.setItems(list)
            }
        }


    }
    // endregion

    // region OVERRIDDEN
    override fun onItemClick(position: Int, view: View) {
    }
    // endregion

    // region UTIL
    private fun initRecyclerView() {
        viewDataBinding?.let {
            it.contentRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
                android.util.Log.d("mine", "initUserInterface and details setting adapter")
                adapter = this@ItemDetailsFragment.adapter
            }
        }
    }
    // endregion


}
