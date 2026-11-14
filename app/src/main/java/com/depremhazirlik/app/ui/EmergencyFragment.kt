package com.depremhazirlik.app.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.depremhazirlik.app.R
import com.depremhazirlik.app.adapters.EmergencyAdapter
import com.depremhazirlik.app.databinding.FragmentEmergencyBinding

class EmergencyFragment : Fragment(R.layout.fragment_emergency) {

    private var _binding: FragmentEmergencyBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEmergencyBinding.bind(view)

        binding.emergencyRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.emergencyRecycler.adapter = EmergencyAdapter { number -> dial(number) }
    }

    private fun dial(number: String) {
        try {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")))
        } catch (e: Exception) {
            Toast.makeText(requireContext(), R.string.emergency_dial_error, Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
