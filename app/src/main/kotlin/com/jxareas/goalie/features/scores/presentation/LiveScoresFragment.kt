package com.jxareas.goalie.features.scores.presentation

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.jxareas.goalie.databinding.FragmentLiveScoresBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LiveScoresFragment : Fragment() {

    private lateinit var binding: FragmentLiveScoresBinding

    @Inject
    internal lateinit var liveScoresWidgetProvider: LiveScoresWidgetProvider

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentLiveScoresBinding
            .inflate(inflater, container, false)
            .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWebView()
    }

    private fun setupWebView() = binding.webView.run {
        settings.javaScriptEnabled = true
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.progressIndicator.isVisible = true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.progressIndicator.isVisible = false
            }
        }

        loadDataWithBaseURL(null, liveScoresWidgetProvider.websiteData, "text/html", "UTF-8", null)
        setupOnBackPressedDispatcher()
    }

    private fun setupOnBackPressedDispatcher() {
        val onBackPressed = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.webView.canGoBack())
                    binding.webView.goBack()
                else
                    requireActivity().moveTaskToBack(true)
            }

        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressed)
    }

}
