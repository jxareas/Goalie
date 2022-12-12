package com.jxareas.goalie.features.videos.presentation.ui.webviewer

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VideoViewerViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    companion object {
        private const val VIDEO_URL_KEY = "videoUrl"
        private const val EMPTY_VIDEO = ""
    }

    private val videoUrl = savedStateHandle.get<String>(VIDEO_URL_KEY)

    val videoViewerProvider: VideoViewer
        get() = VideoViewer(videoUrl ?: EMPTY_VIDEO)

}
