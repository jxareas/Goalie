package com.jxareas.goalie.di.module

import com.jxareas.goalie.common.extensions.withTimeOutInSeconds
import com.jxareas.goalie.features.videos.data.remote.api.ScoreBatApi
import com.jxareas.goalie.features.videos.data.remote.api.ScoreBatApiImpl
import com.jxareas.goalie.features.videos.data.remote.api.ScoreBatRetrofitApi
import com.jxareas.goalie.features.videos.data.remote.interceptors.LoggingInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Binds
    @Singleton
    fun provideScoreBatApi(scoreBatApiImpl: ScoreBatApiImpl): ScoreBatApi

    companion object {
        private const val DEFAULT_TIMEOUT_IN_SECONDS = 120L

        @Provides
        @Singleton
        fun provideClient() =
            OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor())
                .withTimeOutInSeconds(NetworkModule.DEFAULT_TIMEOUT_IN_SECONDS)
                .build()

        @Provides
        @Singleton
        fun provideConverterFactory(): Moshi =
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        @Provides
        @Singleton
        fun provideRetrofit(client: OkHttpClient, moshi: Moshi) =
            Retrofit.Builder()
                .baseUrl(ScoreBatRetrofitApi.BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
    }

}
