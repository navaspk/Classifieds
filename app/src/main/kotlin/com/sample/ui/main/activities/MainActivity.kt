package com.sample.ui.main.activities

import com.classified.sample.R
import androidx.databinding.library.baseAdapters.BR
import com.classified.sample.databinding.ActivityMainBinding
import com.sample.base.BaseActivity

/**
 * Activity with navigation graph
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    // region Variables
    override val viewModel = MainActivityViewModel::class.java
    override fun getBindingVariable() = BR._all
    override val layoutId = R.layout.activity_main
    // endregion Variables

    //region Overridden Methods
    override fun initUserInterface() {
    }
    //endregion

    // region UTIL
    fun controlMainToolBarVisibility(visibility: Int) {
        viewDataBinding.toolBar.visibility = visibility
    }
    // endregion
}


