package com.sample.ui.main.activities

import com.sample.base.BaseNavigator
import com.sample.base.BaseViewModel
import com.sample.core.domain.entity.ResultsItem
import javax.inject.Inject

/**
 * As a Activity view model: In future we can used for write ultimate world logic
 *
 * And also act as shared view model: to share selected item between multiple fragment
 */
class MainActivityViewModel @Inject constructor() : BaseViewModel<BaseNavigator>() {

    var selectedItem: ResultsItem? = null
}
