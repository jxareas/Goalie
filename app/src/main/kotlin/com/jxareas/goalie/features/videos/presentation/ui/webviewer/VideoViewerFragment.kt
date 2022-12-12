package com.jxareas.goalie.features.videos.presentation.ui.webviewer

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jxareas.goalie.databinding.FragmentVideoViewerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoViewerFragment : Fragment() {

    private var _binding: FragmentVideoViewerBinding? = null
    private val binding: FragmentVideoViewerBinding
        get() = _binding!!

    private val viewModel: VideoViewerViewModel by viewModels()

    companion object {
        const val TOTAL_LOADING_PROGRESS = 100
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentVideoViewerBinding
            .inflate(inflater, container, false)
            .also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() = binding.run {
        webView.apply {
            settings.javaScriptEnabled = true
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true
            webChromeClient = object : WebChromeClient() {

                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)

                    progressBar.setProgressCompat(newProgress, true)
                    if (newProgress == TOTAL_LOADING_PROGRESS) {
                        progressBar.isVisible = false
                    }
                }
            }
            loadDataWithBaseURL(
                null,
                viewModel.videoViewerProvider.websiteData,
                "text/html",
                "UTF-8",
                null
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
