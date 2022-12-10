package com.jxareas.goalie.di

import com.jxareas.goalie.BuildConfig
import com.jxareas.goalie.utils.ScoreBatToken
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
    fun provideScoreBatWidgetToken() : ScoreBatToken =
        ScoreBatToken(token = BuildConfig.SCORE_BAT_TOKEN)

}
