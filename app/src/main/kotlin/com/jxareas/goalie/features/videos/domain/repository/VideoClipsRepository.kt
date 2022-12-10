package com.jxareas.goalie.features.videos.domain.repository

import com.jxareas.goalie.features.videos.data.NetworkResult
import com.jxareas.goalie.features.videos.data.dto.VideoClipStatus
import kotlinx.coroutines.flow.Flow

interface VideoClipsRepository {
    fun getVideoClipsFlow(): Flow<NetworkResult<List<VideoClipStatus>>>
}
