package com.jxareas.goalie.features.videos.data.helper

inline infix fun <T> NetworkResult<T>.success(predicate: (data: T) -> Unit): NetworkResult<T> {
    if (this is NetworkResult.Success && this.data != null) {
        predicate.invoke(this.data)
    }
    return this
}

inline infix fun <T> NetworkResult<T>.error(predicate: (data: Throwable) -> Unit) {
    if (this is NetworkResult.Error) {
        predicate.invoke(this.throwable)
    }
}
