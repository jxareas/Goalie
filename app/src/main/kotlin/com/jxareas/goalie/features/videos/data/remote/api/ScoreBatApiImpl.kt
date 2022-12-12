package com.jxareas.goalie.features.videos.data.remote.api

import com.jxareas.goalie.common.utils.ApiVideoToken
import com.jxareas.goalie.features.videos.data.dto.VideoClipsResponse
import retrofit2.Response
import javax.inject.Inject

class ScoreBatApiImpl @Inject constructor(
    private val apiWidgetToken: ApiVideoToken,
    private val retrofitApi: ScoreBatRetrofitApi
) :
    ScoreBatApi {

    override suspend fun getVideoClips(): Response<VideoClipsResponse> =
        retrofitApi.getVideoClips(apiWidgetToken.token)
}
