package com.jxareas.goalie.features.videos.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jxareas.goalie.features.videos.data.helper.NetworkResult
import com.jxareas.goalie.features.videos.domain.repository.VideoClipsRepository
import com.jxareas.goalie.features.videos.presentation.helper.VideoClipsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class VideoClipsViewModel @Inject constructor(
    private val repository: VideoClipsRepository
) : ViewModel() {

    private val _videoClips: MutableStateFlow<VideoClipsState> =
        MutableStateFlow(NetworkResult.Success(null))
    val videoClips = _videoClips.asStateFlow()

    private var fetchVideoClipsJob: Job? = null

    init {
        launchFetchVideoClipsJob()
    }

    fun onRefreshVideoClips() = launchFetchVideoClipsJob()

    private fun launchFetchVideoClipsJob() {
        fetchVideoClipsJob?.cancel()
        fetchVideoClipsJob = repository.getVideoClipsFlow()
            .onEach { videoClips -> _videoClips.value = videoClips }
            .launchIn(viewModelScope)
    }
}
