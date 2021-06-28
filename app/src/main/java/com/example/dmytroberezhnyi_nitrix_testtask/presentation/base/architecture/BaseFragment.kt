package com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.model.NavigationModel
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.model.SnackbarModel
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<D : ViewDataBinding, VM: BaseViewModel> : Fragment() {

    abstract val vm: VM

    protected lateinit var viewDataBinding: D

    protected lateinit var navController: NavController

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        viewDataBinding.lifecycleOwner = this
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = NavHostFragment.findNavController(this)
        performDataBinding(viewDataBinding)
        lifecycle.addObserver(vm)

        vm.navEvent.observe(viewLifecycleOwner, { this.onNavigateTo(it) })
        vm.snackLiveEvent.observe(viewLifecycleOwner, { this.showSnackBar(it) })
        vm.showProgressLoadingEvent.observe(viewLifecycleOwner, { showProgressLoading() })
        vm.hideProgressLoadingEvent.observe(viewLifecycleOwner, { hideProgressLoading() })
    }

    protected open fun performDataBinding(viewDataBinding: D) {
        this.viewDataBinding.executePendingBindings()
    }

    protected fun onNavigateTo(navigationModel: NavigationModel?) {
        navigationModel?.let {
            when {
                it.popBack ->
                    navController.navigateUp()
                it.direction != null && it.extras != null ->
                    navController.navigate(
                        it.direction!!,
                        it.extras!!
                    )
                it.direction != null -> {
                    navController.navigate(it.direction!!)
                }
            }
            vm.navEvent.value = null
        }
    }

    protected fun showSnackBar(snackBarModel: SnackbarModel) {
        val message =
            snackBarModel.idResMessage?.let { getString(it) } ?: snackBarModel.message ?: ""
        view?.let {
            val snackBar = Snackbar.make(it, message, snackBarModel.duration)
            snackBarModel.actionTitle?.let { res ->
                snackBar.setAction(getString(res)) {
                    snackBarModel.action?.invoke()
                }
            }
            snackBar.show()
        }
    }

    protected fun showProgressLoading() {
        (activity as? BaseActivity<*, *>)?.showProgressLoading()
    }

    protected fun hideProgressLoading() {
        (activity as? BaseActivity<*, *>)?.hideProgressLoading()
    }
}