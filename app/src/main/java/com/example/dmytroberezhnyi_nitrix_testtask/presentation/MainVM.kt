package com.example.dmytroberezhnyi_nitrix_testtask.presentation

import com.example.dmytroberezhnyi_nitrix_testtask.di.module.Person
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture.BaseViewModel
import javax.inject.Inject

class MainVM @Inject constructor(val person: Person): BaseViewModel() {
}