package com.jxareas.goalie.features.videos.data.dto

data class VideoClipStatus(
    val isPlaceholder: Boolean = false,
    val data: VideoClipDto,
) {
    companion object {
        fun getClipStatesPlaceholder(): List<VideoClipStatus> {
            val clipStates = mutableListOf<VideoClipStatus>()
            for (i in 1..20) {
                val videoClipStatus = VideoClipStatus(isPlaceholder = true, data = VideoClipDto())
                clipStates.add(videoClipStatus)
            }
            return clipStates.toList()
        }
    }

}
