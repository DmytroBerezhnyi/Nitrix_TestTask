package com.example.dmytroberezhnyi_nitrix_testtask.data.network.api

import com.example.dmytroberezhnyi_nitrix_testtask.data.network.model.VideosResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoSearchAPI {

    @GET("youtube/v3/search")
    fun getVideos(
        @Query("q") query: String,
        @Query("part") part: String = "snippet",
        @Query("key") key: String = "AIzaSyDH7yXY_1DVwYpi8xQJjv3HlKrK-paHhoI",
        @Query("maxResults") maxResults: Int = 20,
        @Query("type") type: String = "video",
    ): Observable<VideosResponse>
}

//https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=20&q=Cat&type=video&key=AIzaSyDH7yXY_1DVwYpi8xQJjv3HlKrK-paHhoI