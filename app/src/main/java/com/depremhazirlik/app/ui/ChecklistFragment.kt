package com.depremhazirlik.app.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.depremhazirlik.app.R
import com.depremhazirlik.app.adapters.ChecklistAdapter
import com.depremhazirlik.app.data.ChecklistData
import com.depremhazirlik.app.data.ChecklistStore
import com.depremhazirlik.app.databinding.FragmentChecklistBinding

class ChecklistFragment : Fragment(R.layout.fragment_checklist) {

    private var _binding: FragmentChecklistBinding? = null
    private val binding get() = _binding!!

    private var store: ChecklistStore? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentChecklistBinding.bind(view)

        val checklistStore = ChecklistStore(requireContext())
        store = checklistStore

        binding.checklistRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.checklistRecycler.adapter =
            ChecklistAdapter(checklistStore) { updateProgress() }

        updateProgress()
    }

    private fun updateProgress() {
        val currentStore = store ?: return
        val total = ChecklistData.total()
        val done = currentStore.completedCount()
        val percent = if (total == 0) 0 else (done * 100) / total

        binding.checklistProgress.progress = percent
        binding.checklistProgressLabel.text =
            getString(R.string.checklist_progress_label, done, total)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        store = null
    }
}
