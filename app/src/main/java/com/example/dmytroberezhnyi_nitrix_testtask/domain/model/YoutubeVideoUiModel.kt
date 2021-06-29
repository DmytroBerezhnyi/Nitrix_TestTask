package com.example.dmytroberezhnyi_nitrix_testtask.domain.model

import com.example.dmytroberezhnyi_nitrix_testtask.data.network.model.VideosResponse

data class YoutubeVideoUiModel(
    val videoId: String,
    val channelId: String,
    val thumbnailUrl: String,
    val title: String,
    val description: String,
    val publishedAt: String,
    val channelTitle: String,
)

fun VideosResponse.toYoutubeVideoUiModelList(): List<YoutubeVideoUiModel> {
    return mutableListOf<YoutubeVideoUiModel>().apply {
        items.forEach {
            add(
                YoutubeVideoUiModel(
                    videoId = it.id.videoId,
                    channelId = it.snippet.channelId,
                    thumbnailUrl = it.snippet.thumbnails.high.url,
                    title = it.snippet.title,
                    description = it.snippet.description,
                    publishedAt = it.snippet.publishedAt,
                    channelTitle = it.snippet.channelTitle,
                )
            )
        }
    }
}