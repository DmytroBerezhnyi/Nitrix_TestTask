package com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.App
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture.BaseViewModel

fun MutableLiveData<Unit>.notifyLiveData() {
    this.value = null
}

fun <ViewModelType : BaseViewModel> Fragment.createViewModel(clazz: Class<ViewModelType>): ViewModelType {
    return ViewModelProvider(this, (activity?.applicationContext as App).viewModelFactory)[clazz]
}