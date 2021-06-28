package com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.dmytroberezhnyi_nitrix_testtask.R
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.App

abstract class BaseActivity<D : ViewDataBinding, ViewModelType : BaseViewModel>(val clazz: Class<ViewModelType>) :
    AppCompatActivity() {

    lateinit var viewDataBinding: D

    protected lateinit var vm: ViewModelType

    @get:LayoutRes
    abstract val layoutId: Int

    private var mProgressDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        vm = ViewModelProvider(this, (applicationContext as App).viewModelFactory)[clazz]
    }

    fun showProgressLoading() {
        mProgressDialog = buildProgressDialog()
        mProgressDialog?.window?.let { window ->
            window.setGravity(Gravity.CENTER)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        mProgressDialog?.show()
    }

    fun hideProgressLoading() {
        mProgressDialog?.dismiss()
    }

    private fun buildProgressDialog(): AlertDialog {
        val dialogBuilder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog_progress, null)
        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(false)
        return dialogBuilder.create()
    }
}