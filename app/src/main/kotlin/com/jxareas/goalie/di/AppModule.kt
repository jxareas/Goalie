package com.jxareas.goalie.di

import com.jxareas.goalie.BuildConfig
import com.jxareas.goalie.common.utils.ApiVideoToken
import com.jxareas.goalie.common.utils.ApiWidgetToken
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWidgetToken(): ApiWidgetToken =
        ApiWidgetToken(token = BuildConfig.SCORE_BAT_TOKEN)

    @Provides
    @Singleton
    fun provideVideoToken(): ApiVideoToken =
        ApiVideoToken(token = BuildConfig.VIDEO_API_TOKEN)


}
