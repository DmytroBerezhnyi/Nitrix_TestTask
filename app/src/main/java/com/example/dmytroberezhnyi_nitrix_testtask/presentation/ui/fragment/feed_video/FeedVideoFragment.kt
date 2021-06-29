package com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.fragment.feed_video

import android.os.Bundle
import android.view.View
import com.example.dmytroberezhnyi_nitrix_testtask.R
import com.example.dmytroberezhnyi_nitrix_testtask.databinding.FragmentFeedVideoBinding
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture.BaseFragment
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.extension.createViewModel
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.adapter.FeedVideoAdapter

class FeedVideoFragment : BaseFragment<FragmentFeedVideoBinding, FeedVideoVM>() {

    override val layoutId: Int
        get() = R.layout.fragment_feed_video

    override val vm: FeedVideoVM
        get() = createViewModel(FeedVideoVM::class.java)

    private val feedVideoAdapter by lazy {
        FeedVideoAdapter(
            onClick = {

            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewObservers()
        setupView()
    }

    private fun setupView() {
        viewDataBinding.rvVideos.adapter = feedVideoAdapter
        vm.getVideos()
    }

    private fun setupViewObservers() {
        vm.youtubeVideoUiModelList.observe(viewLifecycleOwner, {
            feedVideoAdapter.submitList(it)
        })
    }
}