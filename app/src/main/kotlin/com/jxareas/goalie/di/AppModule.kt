package com.jxareas.goalie.di

import com.jxareas.goalie.BuildConfig
import com.jxareas.goalie.utils.WidgetToken
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
    fun provideToken() : WidgetToken =
        WidgetToken(token = BuildConfig.SCORE_BAT_TOKEN)

}
