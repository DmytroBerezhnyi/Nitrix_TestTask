package com.example.dmytroberezhnyi_nitrix_testtask.di.module

import com.example.dmytroberezhnyi_nitrix_testtask.data.network.api.VideoSearchAPI
import com.example.dmytroberezhnyi_nitrix_testtask.data.network.repository.VideoDataRepository
import com.example.dmytroberezhnyi_nitrix_testtask.domain.repository.VideoRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    @Provides
    fun provideVideoSearchApi(retrofit: Retrofit): VideoSearchAPI =
        retrofit.create(VideoSearchAPI::class.java)

    @Provides
    fun provideVideoSearchRepository(videoSearchAPI: VideoSearchAPI): VideoRepository {
        return VideoDataRepository(videoSearchAPI)
    }
}