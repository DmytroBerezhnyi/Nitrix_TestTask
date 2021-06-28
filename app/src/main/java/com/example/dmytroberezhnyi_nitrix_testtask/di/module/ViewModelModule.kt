package com.example.dmytroberezhnyi_nitrix_testtask.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dmytroberezhnyi_nitrix_testtask.di.ViewModelFactory
import com.example.dmytroberezhnyi_nitrix_testtask.di.ViewModelKey
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.activity.MainVM
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.fragment.main.FeedVideoVM
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.fragment.splash.SplashVM
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.fragment.view_video.ViewPlayerVM
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

    @Binds
    @IntoMap
    @ViewModelKey(SplashVM::class)
    abstract fun splashViewModel(viewModel: SplashVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FeedVideoVM::class)
    abstract fun feedVideoViewModel(feedVideoVM: FeedVideoVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewPlayerVM::class)
    abstract fun videoPlayerViewModel(viewPlayerVM: ViewPlayerVM): ViewModel
}