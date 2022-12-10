package com.jxareas.goalie.features.videos.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jxareas.goalie.databinding.FragmentVideosBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideosFragment : Fragment() {

    private var _binding: FragmentVideosBinding? = null
    private val binding: FragmentVideosBinding
        get() = _binding!!

    private val viewModel: VideosViewModel by viewModels()

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
        setupSwipeRefreshLayout()
    }

    private fun setupSwipeRefreshLayout() = binding.swipeRefresh.run {
        setOnRefreshListener { viewModel.onRefreshVideoClips() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
