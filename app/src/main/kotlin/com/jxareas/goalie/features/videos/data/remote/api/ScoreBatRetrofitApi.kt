package com.jxareas.goalie.features.videos.data.remote.api

import com.jxareas.goalie.features.videos.data.dto.VideoClipsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ScoreBatRetrofitApi {

    companion object {
        const val BASE_URL: String = "https://www.scorebat.com/"
    }

    @GET("video-api/v3/feed")
    suspend fun getVideoClips(
        @Query("token") token: String
    ): Response<VideoClipsResponse>

}
