package com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.fragment.splash

import androidx.lifecycle.liveData
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture.BaseViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class SplashVM @Inject constructor(): BaseViewModel() {

    val showFeedVideoEvent = liveData {
        delay(2500)
        emit(true)
    }
}