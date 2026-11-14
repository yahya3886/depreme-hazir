package com.depremhazirlik.app.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.depremhazirlik.app.R
import com.depremhazirlik.app.adapters.GuideAdapter
import com.depremhazirlik.app.databinding.FragmentGuideBinding

class GuideFragment : Fragment(R.layout.fragment_guide) {

    private var _binding: FragmentGuideBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGuideBinding.bind(view)

        binding.guideRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.guideRecycler.adapter = GuideAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
