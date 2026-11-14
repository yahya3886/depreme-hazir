package com.depremhazirlik.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.depremhazirlik.app.data.ChecklistData
import com.depremhazirlik.app.data.ChecklistItem
import com.depremhazirlik.app.data.ChecklistSection
import com.depremhazirlik.app.data.ChecklistStore
import com.depremhazirlik.app.databinding.ItemChecklistBinding
import com.depremhazirlik.app.databinding.ItemChecklistSectionBinding

/**
 * Kontrol listesini bölüm başlıkları ve maddeler halinde gösterir.
 */
class ChecklistAdapter(
    private val store: ChecklistStore,
    private val onProgressChanged: () -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private sealed interface Row
    private data class SectionRow(val section: ChecklistSection) : Row
    private data class ItemRow(val item: ChecklistItem) : Row

    private val rows: List<Row> = buildList {
        for (section in ChecklistData.sections) {
            add(SectionRow(section))
            for (item in ChecklistData.items) {
                if (item.sectionId == section.id) add(ItemRow(item))
            }
        }
    }

    override fun getItemViewType(position: Int): Int = when (rows[position]) {
        is SectionRow -> TYPE_SECTION
        is ItemRow -> TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == TYPE_SECTION) {
            SectionHolder(ItemChecklistSectionBinding.inflate(inflater, parent, false))
        } else {
            ItemHolder(ItemChecklistBinding.inflate(inflater, parent, false))
        }
    }

    override fun getItemCount(): Int = rows.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val row = rows[position]) {
            is SectionRow -> (holder as SectionHolder).bind(row.section)
            is ItemRow -> (holder as ItemHolder).bind(row.item)
        }
    }

    private inner class SectionHolder(
        private val binding: ItemChecklistSectionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(section: ChecklistSection) {
            binding.sectionTitle.text = section.title
            binding.sectionSubtitle.text = section.subtitle
        }
    }

    private inner class ItemHolder(
        private val binding: ItemChecklistBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ChecklistItem) {
            binding.itemTitle.text = item.title
            binding.itemSubtitle.text = item.subtitle

            binding.itemCheck.setOnCheckedChangeListener(null)
            binding.itemCheck.isChecked = store.isChecked(item.id)
            binding.itemCheck.setOnCheckedChangeListener { _, checked ->
                store.setChecked(item.id, checked)
                onProgressChanged()
            }

            binding.root.setOnClickListener {
                binding.itemCheck.toggle()
            }
        }
    }

    companion object {
        private const val TYPE_SECTION = 0
        private const val TYPE_ITEM = 1
    }
}
