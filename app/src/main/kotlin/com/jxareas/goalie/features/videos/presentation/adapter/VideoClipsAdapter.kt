package com.jxareas.goalie.features.videos.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import com.jxareas.goalie.common.extensions.runOnInflater
import com.jxareas.goalie.databinding.ListItemVideoClipBinding
import com.jxareas.goalie.databinding.ShimmerItemVideoClipBinding
import com.jxareas.goalie.features.videos.data.dto.VideoClipDto
import com.jxareas.goalie.features.videos.data.dto.VideoClipStatus

class VideoClipsAdapter(
    private val onVideoClipClicked: (VideoClipDto) -> Unit
) : ListAdapter<VideoClipStatus, VideoClipViewHolder>(
    AsyncDifferConfig.Builder(VideoClipStatusDiffCallback).build()
) {
    companion object {
        const val PLACEHOLDER_LIST_ITEM_VIEW = 0
        const val VIDEO_LIST_ITEM_VIEW = 1
    }

    override fun getItemViewType(position: Int): Int =
        if (currentList[position].isPlaceholder)
            PLACEHOLDER_LIST_ITEM_VIEW
        else VIDEO_LIST_ITEM_VIEW

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoClipViewHolder =
        when (viewType) {
            PLACEHOLDER_LIST_ITEM_VIEW ->
                VideoClipViewHolder.PlaceholderEmptyViewHolder(parent runOnInflater ShimmerItemVideoClipBinding::inflate)
            VIDEO_LIST_ITEM_VIEW ->
                VideoClipViewHolder.VideoViewHolder(
                    parent runOnInflater ListItemVideoClipBinding::inflate,
                    onVideoClipClicked
                )
            else -> throw IllegalArgumentException("Invalid ViewType")
        }

    override fun onBindViewHolder(holder: VideoClipViewHolder, position: Int) =
        when (holder) {
            is VideoClipViewHolder.PlaceholderEmptyViewHolder -> Unit
            is VideoClipViewHolder.VideoViewHolder -> holder.bind(currentList[position])
        }

}
