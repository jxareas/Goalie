package com.jxareas.goalie.features.videos.data.remote.interceptors

import okhttp3.logging.HttpLoggingInterceptor

object LoggingInterceptor {
    operator fun invoke() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}
