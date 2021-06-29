package com.example.dmytroberezhnyi_nitrix_testtask.domain.repository

import com.example.dmytroberezhnyi_nitrix_testtask.domain.model.YoutubeVideoUiModel
import io.reactivex.rxjava3.core.Observable

interface VideoRepository {

    fun getVideoList(query: String): Observable<List<YoutubeVideoUiModel>>
}