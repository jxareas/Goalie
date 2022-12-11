package com.jxareas.goalie.features.videos.data.repository

import com.jxareas.goalie.features.videos.data.dto.VideoClipDto.Companion.toVideoClipStatus
import com.jxareas.goalie.features.videos.data.dto.VideoClipStatus
import com.jxareas.goalie.features.videos.data.helper.NetworkResult
import com.jxareas.goalie.features.videos.data.remote.api.ScoreBatApi
import com.jxareas.goalie.features.videos.domain.repository.VideoClipsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class VideoClipsRepositoryImpl @Inject constructor(private val api: ScoreBatApi) :
    VideoClipsRepository {
    override fun getVideoClipsFlow(): Flow<NetworkResult<List<VideoClipStatus>>> = flow {
        emit(NetworkResult.Loading)
        try {
            val response = api.getVideoClips()
            response.body()?.response?.let { videoClips ->
                val videoClipStatuses =
                    videoClips.map { videoClip -> videoClip.toVideoClipStatus() }
                emit(NetworkResult.Success(videoClipStatuses))
            } ?: run {
                throw HttpException(response)
            }
        } catch (networkException: HttpException) {
            emit(NetworkResult.Error(networkException))
        }
    }


}
