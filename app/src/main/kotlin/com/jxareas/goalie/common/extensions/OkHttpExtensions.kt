package com.jxareas.goalie.common.extensions

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

fun OkHttpClient.Builder.withTimeOutInSeconds(seconds: Long) =
    callTimeout(seconds, TimeUnit.SECONDS)
        .writeTimeout(seconds, TimeUnit.SECONDS)
        .readTimeout(seconds, TimeUnit.SECONDS)
