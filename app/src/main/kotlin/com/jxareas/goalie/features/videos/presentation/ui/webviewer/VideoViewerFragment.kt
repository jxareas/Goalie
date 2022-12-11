package com.jxareas.goalie.features.videos.presentation.ui.webviewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jxareas.goalie.databinding.FragmentVideoViewerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoViewerFragment : Fragment() {

    private var _binding: FragmentVideoViewerBinding? = null
    private val binding: FragmentVideoViewerBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentVideoViewerBinding
            .inflate(inflater, container, false)
            .also { _binding = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
