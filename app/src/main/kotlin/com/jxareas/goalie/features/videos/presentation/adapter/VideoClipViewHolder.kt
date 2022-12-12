package com.jxareas.goalie.features.videos.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.viewbinding.ViewBinding
import coil.load
import com.jxareas.goalie.R
import com.jxareas.goalie.common.utils.DateUtils.formatDateTime
import com.jxareas.goalie.databinding.ListItemVideoClipBinding
import com.jxareas.goalie.databinding.ShimmerItemVideoClipBinding
import com.jxareas.goalie.features.videos.data.dto.VideoClipDto
import com.jxareas.goalie.features.videos.data.dto.VideoClipStatus

sealed class VideoClipViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class PlaceholderEmptyViewHolder(
        binding: ShimmerItemVideoClipBinding
    ) : VideoClipViewHolder(binding)

    class VideoViewHolder(
        private val binding: ListItemVideoClipBinding,
        private val onVideoClipClicked: (VideoClipDto) -> Unit,
    ) : VideoClipViewHolder(binding) {


        fun bind(item: VideoClipStatus) = binding.run {
            val context = root.context

            thumbnail.load(item.data.thumbnail) {
                val circularProgressDrawable = CircularProgressDrawable(context).apply {
                    strokeWidth = 5f
                    centerRadius = 30f
                    start()
                }
                placeholder(circularProgressDrawable)
                error(R.drawable.ic_placeholder)
            }

            date.text = formatDateTime(item.data.date)
            type.text =
                context.getString(R.string.detail, item.data.videos?.get(0)?.title ?: "")
            competition.text = context.getString(R.string.detail, item.data.competition)
            title.text = item.data.title

            root.setOnClickListener {
                onVideoClipClicked(item.data)
            }
        }
    }


}
