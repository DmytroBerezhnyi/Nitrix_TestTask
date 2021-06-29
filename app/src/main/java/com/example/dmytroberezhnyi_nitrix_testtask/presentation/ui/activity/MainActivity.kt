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
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }
}