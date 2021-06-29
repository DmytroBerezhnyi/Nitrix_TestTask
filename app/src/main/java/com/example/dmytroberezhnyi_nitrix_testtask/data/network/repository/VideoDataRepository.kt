package com.example.dmytroberezhnyi_nitrix_testtask.data.network.repository

import com.example.dmytroberezhnyi_nitrix_testtask.data.network.api.VideoSearchAPI
import com.example.dmytroberezhnyi_nitrix_testtask.domain.model.YoutubeVideoUiModel
import com.example.dmytroberezhnyi_nitrix_testtask.domain.model.toYoutubeVideoUiModelList
import com.example.dmytroberezhnyi_nitrix_testtask.domain.repository.VideoRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class VideoDataRepository @Inject constructor(private val videoSearchAPI: VideoSearchAPI) :
    VideoRepository {

    override fun getVideoList(query: String): Observable<List<YoutubeVideoUiModel>> {
        return videoSearchAPI.getVideos(query).map {
            it.toYoutubeVideoUiModelList()
        }
    }
}