package com.depremhazirlik.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.depremhazirlik.app.data.GuideData
import com.depremhazirlik.app.data.GuideSection
import com.depremhazirlik.app.databinding.ItemGuideBulletBinding
import com.depremhazirlik.app.databinding.ItemGuideHeaderBinding

/**
 * Katlanabilir rehber listesi: başlığa tıklayınca maddeler açılır/kapanır.
 */
class GuideAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private sealed interface Row {
        data class HeaderRow(val section: GuideSection) : Row
        data class BulletRow(val text: String) : Row
    }

    private val expanded: MutableSet<String> = mutableSetOf(GuideData.sections.first().id)
    private var rows: List<Row> = buildRows()

    private fun buildRows(): List<Row> = buildList {
        for (section in GuideData.sections) {
            add(HeaderRow(section))
            if (section.id in expanded) {
                for (bullet in section.bullets) add(BulletRow(bullet))
            }
        }
    }

    override fun getItemViewType(position: Int): Int = when (rows[position]) {
        is HeaderRow -> TYPE_HEADER
        is BulletRow -> TYPE_BULLET
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == TYPE_HEADER) {
            HeaderHolder(ItemGuideHeaderBinding.inflate(inflater, parent, false))
        } else {
            BulletHolder(ItemGuideBulletBinding.inflate(inflater, parent, false))
        }
    }

    override fun getItemCount(): Int = rows.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val row = rows[position]) {
            is HeaderRow -> (holder as HeaderHolder).bind(row.section)
            is BulletRow -> (holder as BulletHolder).bind(row.text)
        }
    }

    private inner class HeaderHolder(
        private val binding: ItemGuideHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(section: GuideSection) {
            binding.guideHeaderTitle.text = section.title

            val isOpen = section.id in expanded
            binding.guideHeaderIcon.rotation = if (isOpen) 180f else 0f

            binding.root.setOnClickListener {
                if (!expanded.remove(section.id)) {
                    expanded.add(section.id)
                }
                rows = buildRows()
                notifyDataSetChanged()
            }
        }
    }

    private inner class BulletHolder(
        private val binding: ItemGuideBulletBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(text: String) {
            binding.guideBulletText.text = text
        }
    }

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_BULLET = 1
    }
}
