package com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.activity

import androidx.lifecycle.MutableLiveData
import com.example.dmytroberezhnyi_nitrix_testtask.data.network.model.VideosResponse
import com.example.dmytroberezhnyi_nitrix_testtask.domain.repository.VideoRepository
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MainVM @Inject constructor(private val videoRepository: VideoRepository) : BaseViewModel() {

    val videoResponse = MutableLiveData<VideosResponse>()

    fun getVideos() {
        videoRepository.getVideoList("Cat")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it?.let { videosResponse ->
                    this.videoResponse.value = videosResponse
                }
            }
    }
}