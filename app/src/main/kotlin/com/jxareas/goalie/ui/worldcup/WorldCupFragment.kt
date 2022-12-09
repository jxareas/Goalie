package com.jxareas.goalie.ui.worldcup

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
import androidx.navigation.fragment.findNavController
import com.jxareas.goalie.databinding.FragmentWorldCupBinding
import com.jxareas.goalie.utils.ScoreBatWebUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorldCupFragment : Fragment() {

    private var _binding: FragmentWorldCupBinding? = null
    private val binding: FragmentWorldCupBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupOnBackPressedDispatcher()
    }

    private fun setupOnBackPressedDispatcher() {
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (binding.webView.canGoBack())
                        binding.webView.goBack()
                    else
                        findNavController().navigateUp()
                }

            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentWorldCupBinding
            .inflate(inflater, container, false)
            .also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWebView()
    }

    private fun setupWebView() = binding.webView.apply {
        settings.javaScriptEnabled = true
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                binding.progressIndicator.isVisible = true
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                binding.progressIndicator.isVisible = false
                super.onPageFinished(view, url)
            }
        }

        loadDataWithBaseURL(null, ScoreBatWebUtils.websiteData, "text/html", "UTF-8", null)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
