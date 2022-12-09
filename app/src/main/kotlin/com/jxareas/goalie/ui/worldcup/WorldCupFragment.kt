package com.jxareas.goalie.ui.worldcup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jxareas.goalie.databinding.FragmentWorldCupBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorldCupFragment : Fragment() {

    private var _binding: FragmentWorldCupBinding? = null
    private val binding: FragmentWorldCupBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentWorldCupBinding
            .inflate(inflater, container, false)
            .also { _binding = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
