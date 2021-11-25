package com.sample.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseActivity<VDB : ViewDataBinding, BVM : BaseViewModel<*>> :
        DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var injectedViewModel: BVM

    lateinit var viewDataBinding: VDB

    abstract val viewModel: Class<BVM>

    abstract fun getBindingVariable(): Int

    @get:LayoutRes
    abstract val layoutId: Int

    private val disposableDelegate = lazy { CompositeDisposable() }

    private val compositeDisposable by disposableDelegate

    //region LIFECYCLE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        performDataBinding()
        initUserInterface()
    }

    override fun onDestroy() {
        if (disposableDelegate.isInitialized()) {
            compositeDisposable.dispose()
        }
        super.onDestroy()
    }

    // endregion

    protected abstract fun initUserInterface()

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        injectedViewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModel)
        viewDataBinding.setVariable(getBindingVariable(), injectedViewModel)
        viewDataBinding.executePendingBindings()
    }

}
