package com.jxareas.goalie.features.videos.data.dto


data class VideoClipDto(
    val title: String? = null,
    val competition: String? = null,
    val matchviewUrl: String? = null,
    val competitionUrl: String? = null,
    val thumbnail: String? = null,
    val date: String? = null,
    val videos: List<VideoDto>? = emptyList()
) {

    companion object {
        fun VideoClipDto.toVideoClipStatus() = VideoClipStatus(data = this)
    }

}
