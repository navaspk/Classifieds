package com.sample.ui.main.fragment.home

import com.sample.base.BaseNavigator
import com.sample.core.domain.entity.ResultsItem

interface AllItemFragmentNavigator: BaseNavigator {

    fun somethingWentWrong(responseError: Boolean = false)
}
