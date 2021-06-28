package com.example.dmytroberezhnyi_nitrix_testtask.presentation

import android.app.Application
import com.example.dmytroberezhnyi_nitrix_testtask.BuildConfig
import com.example.dmytroberezhnyi_nitrix_testtask.di.ViewModelFactory
import com.example.dmytroberezhnyi_nitrix_testtask.di.component.DaggerMyComponent
import timber.log.Timber
import javax.inject.Inject

class App: Application() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        val myComponent = DaggerMyComponent.create()
        myComponent.inject(this)
    }
}