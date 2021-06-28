package com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.fragment.splash

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.dmytroberezhnyi_nitrix_testtask.R
import com.example.dmytroberezhnyi_nitrix_testtask.databinding.FragmentSplashBinding
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture.BaseFragment
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.extension.createViewModel
import com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.model.NavigationModel

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashVM>() {

    override val layoutId: Int
        get() = R.layout.fragment_splash

    override val vm: SplashVM
        get() = createViewModel(SplashVM::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(R.drawable.youtube_play).into(viewDataBinding.ivSplash)
        setupViewObservers()
    }

    private fun setupViewObservers() {
        vm.showFeedVideoEvent.observe(viewLifecycleOwner, {
            if (it) {
                onNavigateTo(NavigationModel(SplashFragmentDirections.actionSplashScreenToFeedVideoScreen()))
            }
        })
    }
}