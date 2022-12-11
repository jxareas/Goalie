package com.jxareas.goalie.features.videos.presentation.helper

import com.jxareas.goalie.features.videos.data.dto.VideoClipStatus
import com.jxareas.goalie.features.videos.data.helper.NetworkResult

typealias VideoClipsState = NetworkResult<List<VideoClipStatus>?>

val VideoClipsState?.isNotNull: Boolean
    get() = this != null

val VideoClipsState?.isInitialState: Boolean
    get() = isNotNull && this is NetworkResult.Success && data == null

val VideoClipsState?.isSucceeded: Boolean
    get() = isNotNull && this is NetworkResult.Success && data != null

val VideoClipsState?.isError: Boolean
    get() = isNotNull && this is NetworkResult.Error

val VideoClipsState?.isLoading: Boolean
    get() = isNotNull && this is NetworkResult.Loading

