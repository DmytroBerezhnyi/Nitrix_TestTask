package com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.model

import androidx.navigation.NavDirections
import androidx.navigation.Navigator

data class NavigationModel(
    var direction: NavDirections? = null,
    val popBack: Boolean = false,
    var extras: Navigator.Extras? = null
)