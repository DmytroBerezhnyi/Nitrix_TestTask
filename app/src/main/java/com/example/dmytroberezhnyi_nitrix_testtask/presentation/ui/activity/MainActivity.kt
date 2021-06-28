package com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.dmytroberezhnyi_nitrix_testtask.R
import com.example.dmytroberezhnyi_nitrix_testtask.databinding.ActivityMainBinding
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainVM>(MainVM::class.java) {

    override val layoutId: Int
        get() = R.layout.activity_main

    protected lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inject()
        setupNavigation()
        //setupViewObservers()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    /*private fun inject() {
        val daggerComponent = DaggerMyComponent.create()
        daggerComponent.inject(this)
    }

    private fun setupViewObservers() {
        vm.videoResponse.observe(this, {
            Toast.makeText(this, it.items.size.toString(), Toast.LENGTH_LONG).show()
        })
        vm.showProgressLoadingEvent.notifyLiveData()
        vm.getVideos()
    }*/
}