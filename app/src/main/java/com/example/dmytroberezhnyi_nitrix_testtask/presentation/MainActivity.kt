package com.example.dmytroberezhnyi_nitrix_testtask.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.dmytroberezhnyi_nitrix_testtask.R
import com.example.dmytroberezhnyi_nitrix_testtask.databinding.ActivityMainBinding
import com.example.dmytroberezhnyi_nitrix_testtask.di.ViewModelFactory
import com.example.dmytroberezhnyi_nitrix_testtask.di.component.DaggerMyComponent
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val layoutId: Int
        get() = R.layout.activity_main

    private val vm: MainVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val daggerComponent = DaggerMyComponent.create()
        daggerComponent.inject(this)
        val viewModel = ViewModelProvider(this, viewModelFactory)[MainVM::class.java]
        findViewById<TextView>(R.id.textView).text = viewModel.person.toString()
    }
}