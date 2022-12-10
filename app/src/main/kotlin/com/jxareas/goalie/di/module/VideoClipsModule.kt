package com.jxareas.goalie.di.module

import com.jxareas.goalie.features.videos.data.remote.api.ScoreBatRetrofitApi
import com.jxareas.goalie.features.videos.data.repository.VideoClipsRepositoryImpl
import com.jxareas.goalie.features.videos.domain.repository.VideoClipsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface VideoClipsModule {

    @Binds
    @Singleton
    fun bindVideoClipsRepository(repository: VideoClipsRepositoryImpl): VideoClipsRepository

    companion object {
        @Singleton
        @Provides
        fun provideScoreBatRetrofitApi(retrofit: Retrofit): ScoreBatRetrofitApi =
            retrofit.create()
    }

}
