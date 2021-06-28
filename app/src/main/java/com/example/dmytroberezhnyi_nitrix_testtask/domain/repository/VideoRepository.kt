package com.example.dmytroberezhnyi_nitrix_testtask.domain.repository

import com.example.dmytroberezhnyi_nitrix_testtask.data.network.model.VideosResponse
import io.reactivex.rxjava3.core.Observable

interface VideoRepository {

    fun getVideoList(query: String): Observable<VideosResponse>
}