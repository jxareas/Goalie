package com.jxareas.goalie.features.videos.data

sealed class NetworkResult<out R> {
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Error(val throwable: Throwable) : NetworkResult<Nothing>()
    object Loading : NetworkResult<Nothing>()
}
