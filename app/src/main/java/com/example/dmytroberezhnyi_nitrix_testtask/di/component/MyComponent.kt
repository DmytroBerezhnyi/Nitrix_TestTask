package com.example.dmytroberezhnyi_nitrix_testtask.di.component

import com.example.dmytroberezhnyi_nitrix_testtask.data.network.api.VideoSearchAPI
import com.example.dmytroberezhnyi_nitrix_testtask.di.module.NetworkModule
import com.example.dmytroberezhnyi_nitrix_testtask.di.module.ViewModelModule
import com.example.dmytroberezhnyi_nitrix_testtask.domain.repository.VideoRepository
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.App
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.activity.MainActivity
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.fragment.splash.SplashFragment
import com.google.gson.Gson
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface MyComponent {

    fun gson(): Gson

    fun retrofit(): Retrofit

    fun videoSearchApi(): VideoSearchAPI

    fun provideVideoSearchRepository(): VideoRepository

    fun inject(mainActivity: MainActivity)

    fun inject(application: App)
}