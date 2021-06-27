package com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.extension

import androidx.lifecycle.MutableLiveData

fun MutableLiveData<Unit>.notifyLiveData() {
    this.value = null
}