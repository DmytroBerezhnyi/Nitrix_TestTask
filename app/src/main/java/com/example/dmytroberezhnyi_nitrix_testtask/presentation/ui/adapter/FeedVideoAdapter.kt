package com.example.dmytroberezhnyi_nitrix_testtask.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dmytroberezhnyi_nitrix_testtask.databinding.ItemVideoBinding
import com.example.dmytroberezhnyi_nitrix_testtask.domain.model.YoutubeVideoUiModel

class FeedVideoAdapter(
    private val onClick: ((YoutubeVideoUiModel) -> Unit)
) : ListAdapter<YoutubeVideoUiModel, RecyclerView.ViewHolder>(FeedVideoDiffCallback()) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val youtubeVideoUiModel = getItem(position)
        (holder as YoutubeVideoViewHolder).bind(youtubeVideoUiModel)
        holder.itemView.setOnClickListener {
            onClick.invoke(youtubeVideoUiModel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return YoutubeVideoViewHolder(
            ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    inner class YoutubeVideoViewHolder(
        private val binding: ItemVideoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: YoutubeVideoUiModel) {
            binding.apply {
                youtubeVideoUiModel = item
                executePendingBindings()
            }
        }
    }
}

private class FeedVideoDiffCallback : DiffUtil.ItemCallback<YoutubeVideoUiModel>() {
    override fun areItemsTheSame(
        oldItem: YoutubeVideoUiModel,
        newItem: YoutubeVideoUiModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: YoutubeVideoUiModel,
        newItem: YoutubeVideoUiModel
    ): Boolean {
        return oldItem.videoId == newItem.videoId && oldItem.channelId == newItem.channelId
    }
}