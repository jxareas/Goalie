package com.jxareas.goalie.features.videos.data.remote.api

import com.jxareas.goalie.features.videos.data.dto.VideoClipsResponse
import retrofit2.Response

interface ScoreBatApi {
    suspend fun getVideoClips(): Response<VideoClipsResponse>
}
