package com.jxareas.goalie.ui.scores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jxareas.goalie.databinding.FragmentLiveScoresBinding

class LiveScoresFragment : Fragment() {

    private lateinit var binding: FragmentLiveScoresBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentLiveScoresBinding
            .inflate(inflater, container, false)
            .also { binding = it }.root

}
