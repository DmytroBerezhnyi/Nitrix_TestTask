package com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.fragment.view_video

import com.example.dmytroberezhnyi_nitrix_testtask.R
import com.example.dmytroberezhnyi_nitrix_testtask.databinding.FragmentVideoPlayerBinding
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture.BaseFragment
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.extension.createViewModel

class VideoPlayerFragment : BaseFragment<FragmentVideoPlayerBinding, ViewPlayerVM>() {

    override val layoutId: Int
        get() = R.layout.fragment_video_player

    override val vm: ViewPlayerVM
        get() = createViewModel(ViewPlayerVM::class.java)
}