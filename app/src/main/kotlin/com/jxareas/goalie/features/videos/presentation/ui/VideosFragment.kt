package com.jxareas.goalie.features.videos.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialSharedAxis
import com.jxareas.goalie.R
import com.jxareas.goalie.common.extensions.getLong
import com.jxareas.goalie.common.extensions.postponeAndStartTransitionOnPreDraw
import com.jxareas.goalie.databinding.FragmentVideosBinding
import com.jxareas.goalie.features.videos.data.dto.VideoClipDto
import com.jxareas.goalie.features.videos.data.dto.VideoClipStatus
import com.jxareas.goalie.features.videos.data.helper.error
import com.jxareas.goalie.features.videos.data.helper.success
import com.jxareas.goalie.features.videos.presentation.adapter.VideoClipsAdapter
import com.jxareas.goalie.features.videos.presentation.helper.VideoClipsState
import com.jxareas.goalie.features.videos.presentation.helper.isError
import com.jxareas.goalie.features.videos.presentation.helper.isLoading
import com.jxareas.goalie.features.videos.presentation.helper.isSucceeded
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VideosFragment : Fragment() {

    private var _binding: FragmentVideosBinding? = null
    private val binding: FragmentVideosBinding
        get() = _binding!!

    private val viewModel: VideosViewModel by viewModels()

    private val videoClipsListAdapter = VideoClipsAdapter {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.Y, false).apply {
            interpolator = FastOutSlowInInterpolator()
            duration = resources.getLong(R.integer.material_motion_duration_long_1)
            setPathMotion(MaterialArcMotion())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentVideosBinding
            .inflate(inflater, container, false)
            .also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeAndStartTransitionOnPreDraw()
        setupRecyclerView()
        setupListeners()
        setupCollectors()
    }

    private fun setupCollectors() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.videoClips.collectLatest { videoClipsState ->
                    updateUiFromState(videoClipsState)
                    when {
                        videoClipsState.isLoading -> submitList(List(20) {
                            VideoClipStatus(true, VideoClipDto())
                        })
                        videoClipsState.isSucceeded -> videoClipsState.success { listOfVideos ->
                            submitList(listOfVideos)
                        }
                        videoClipsState.isError -> videoClipsState.error {
                            showErrorView(getString(R.string.server_error))
                        }
                    }
                }
            }
        }
    }

    private fun updateUiFromState(state: VideoClipsState) = binding.run {
        swipeRefresh.run {
            isRefreshing = false
            isVisible = !state.isError
        }
        viewCommonError.root.isVisible = state.isError
    }

    private fun showErrorView(errorMessage: String) {
        binding.viewCommonError.apply {
            title.text = errorMessage
            button.setOnClickListener { viewModel.onRefreshVideoClips() }
        }
    }

    private fun submitList(state: List<VideoClipStatus>?) =
        videoClipsListAdapter.submitList(state)


    private fun setupListeners() = binding.run {
        fab.setOnClickListener { recyclerView.smoothScrollToPosition(0) }
        swipeRefresh.setOnRefreshListener { viewModel.onRefreshVideoClips() }
    }

    private fun setupRecyclerView() = binding.recyclerView.run {
        adapter = videoClipsListAdapter
        layoutManager = LinearLayoutManager(requireContext())
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val firstVisibleItemPosition =
                    (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                if (firstVisibleItemPosition > 0)
                    binding.fab.show()
                else binding.fab.hide()

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
