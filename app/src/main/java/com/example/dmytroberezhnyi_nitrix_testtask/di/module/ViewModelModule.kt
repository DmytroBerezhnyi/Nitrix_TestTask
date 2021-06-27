package com.example.dmytroberezhnyi_nitrix_testtask.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dmytroberezhnyi_nitrix_testtask.di.ViewModelFactory
import com.example.dmytroberezhnyi_nitrix_testtask.di.ViewModelKey
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.MainVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainVM::class)
    abstract fun mainViewModel(viewModel: MainVM): ViewModel
}