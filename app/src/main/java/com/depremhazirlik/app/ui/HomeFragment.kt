package com.depremhazirlik.app.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.depremhazirlik.app.MainActivity
import com.depremhazirlik.app.R
import com.depremhazirlik.app.data.ChecklistData
import com.depremhazirlik.app.data.ChecklistStore
import com.depremhazirlik.app.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var store: ChecklistStore? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        store = ChecklistStore(requireContext())

        binding.btnOpenChecklist.setOnClickListener {
            (requireActivity() as? MainActivity)?.openTab(R.id.nav_checklist)
        }

        binding.btnStartQuiz.setOnClickListener {
            startActivity(Intent(requireContext(), QuizActivity::class.java))
        }

        binding.btnOpenAfad.setOnClickListener {
            openUrl("https://www.afad.gov.tr")
        }
    }

    override fun onResume() {
        super.onResume()
        updateProgress()
    }

    private fun updateProgress() {
        val currentStore = store ?: return
        val total = ChecklistData.total()
        val done = currentStore.completedCount()
        val percent = if (total == 0) 0 else (done * 100) / total

        binding.homeProgress.progress = percent
        binding.homeProgressLabel.text =
            if (done == 0) getString(R.string.home_progress_empty)
            else getString(R.string.checklist_progress_label, done, total)
    }

    private fun openUrl(url: String) {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        } catch (e: Exception) {
            Toast.makeText(requireContext(), R.string.open_error, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        store = null
    }
}
