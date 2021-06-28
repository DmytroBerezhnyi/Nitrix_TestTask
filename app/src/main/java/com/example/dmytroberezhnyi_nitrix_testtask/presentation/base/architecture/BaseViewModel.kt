package com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.model.NavigationModel
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.model.SnackbarModel

abstract class BaseViewModel : ViewModel(), LifecycleObserver {
    val navEvent = MutableLiveData<NavigationModel>()
    val snackLiveEvent = MutableLiveData<SnackbarModel>()
    val showProgressLoadingEvent = MutableLiveData<Unit>()
    val hideProgressLoadingEvent = MutableLiveData<Unit>()
}