package com.example.dmytroberezhnyi_nitrix_testtask.di.module

import dagger.Module
import dagger.Provides

@Module
object MyModule {

    @Provides
    fun providePerson() = Person("Dmytro", "Berezhnyi")
}

data class Person(
    val name: String,
    val surname: String,
)