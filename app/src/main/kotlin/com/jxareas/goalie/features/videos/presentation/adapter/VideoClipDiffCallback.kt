package com.jxareas.goalie.features.videos.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.jxareas.goalie.features.videos.data.dto.VideoClipStatus

object VideoClipStatusDiffCallback : DiffUtil.ItemCallback<VideoClipStatus>() {
    override fun areItemsTheSame(oldItem: VideoClipStatus, newItem: VideoClipStatus): Boolean =
        oldItem.data.matchviewUrl == newItem.data.matchviewUrl


    override fun areContentsTheSame(oldItem: VideoClipStatus, newItem: VideoClipStatus): Boolean =
        oldItem == newItem
}

