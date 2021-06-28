package com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.fragment.main

import com.example.dmytroberezhnyi_nitrix_testtask.R
import com.example.dmytroberezhnyi_nitrix_testtask.databinding.FragmentFeedVideoBinding
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture.BaseFragment
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.extension.createViewModel

class FeedVideoFragment : BaseFragment<FragmentFeedVideoBinding, FeedVideoVM>() {

    override val layoutId: Int
        get() = R.layout.fragment_feed_video

    override val vm: FeedVideoVM
        get() = createViewModel(FeedVideoVM::class.java)
}