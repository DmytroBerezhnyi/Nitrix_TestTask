package com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.fragment.feed_video

import androidx.lifecycle.MutableLiveData
import com.example.dmytroberezhnyi_nitrix_testtask.domain.model.YoutubeVideoUiModel
import com.example.dmytroberezhnyi_nitrix_testtask.domain.repository.VideoRepository
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class FeedVideoVM @Inject constructor(private val videoRepository: VideoRepository): BaseViewModel() {

    val youtubeVideoUiModelList = MutableLiveData<List<YoutubeVideoUiModel>>()

    fun getVideos() {
        videoRepository.getVideoList("Cat")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it?.let { youtubeVideoUiModelList ->
                    this.youtubeVideoUiModelList.value = youtubeVideoUiModelList
                }
            }
    }
}