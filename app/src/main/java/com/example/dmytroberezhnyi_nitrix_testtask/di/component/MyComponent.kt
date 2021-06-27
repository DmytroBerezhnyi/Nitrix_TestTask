package com.example.dmytroberezhnyi_nitrix_testtask.di.component

import com.example.dmytroberezhnyi_nitrix_testtask.di.module.MyModule
import com.example.dmytroberezhnyi_nitrix_testtask.di.module.Person
import com.example.dmytroberezhnyi_nitrix_testtask.di.module.ViewModelModule
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.MainActivity
import dagger.Component

@Component(modules = [MyModule::class, ViewModelModule::class])
interface MyComponent {

    fun person(): Person

    fun inject(mainActivity: MainActivity)
}