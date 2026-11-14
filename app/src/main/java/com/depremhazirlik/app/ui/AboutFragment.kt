package com.depremhazirlik.app.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.depremhazirlik.app.R
import com.depremhazirlik.app.databinding.FragmentAboutBinding

class AboutFragment : Fragment(R.layout.fragment_about) {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAboutBinding.bind(view)

        binding.aboutVersion.text = getString(R.string.about_version, currentVersion())

        binding.btnOpenRepo.setOnClickListener {
            openRepo()
        }
    }

    private fun currentVersion(): String = try {
        val info = requireContext().packageManager
            .getPackageInfo(requireContext().packageName, 0)
        info.versionName ?: VERSION_FALLBACK
    } catch (e: Exception) {
        VERSION_FALLBACK
    }

    private fun openRepo() {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(REPO_URL)))
        } catch (e: Exception) {
            Toast.makeText(requireContext(), R.string.about_open_error, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private companion object {
        const val REPO_URL = "https://github.com/yahya3886/depreme-hazir"
        const val VERSION_FALLBACK = "1.0.0"
    }
}
