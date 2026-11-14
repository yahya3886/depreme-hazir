package com.depremhazirlik.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.depremhazirlik.app.data.EmergencyData
import com.depremhazirlik.app.data.EmergencyNumber
import com.depremhazirlik.app.data.EmergencyTip
import com.depremhazirlik.app.databinding.ItemEmergencyBinding
import com.depremhazirlik.app.databinding.ItemEmergencySectionBinding
import com.depremhazirlik.app.databinding.ItemEmergencyTipBinding

/**
 * Acil numaralar ve bilgilendirme kartlarını listeler.
 */
class EmergencyAdapter(
    private val onCallRequested: (String) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private sealed interface Row
    private data class SectionRow(val title: String) : Row
    private data class NumberRow(val number: EmergencyNumber) : Row
    private data class TipRow(val tip: EmergencyTip) : Row

    private val rows: List<Row> = buildList {
        add(SectionRow("Tek numara"))
        add(NumberRow(EmergencyData.call112))

        add(SectionRow("Kurum hatları"))
        for (number in EmergencyData.institutions) add(NumberRow(number))

        add(SectionRow("Bilgilendirme"))
        for (tip in EmergencyData.tips) add(TipRow(tip))
    }

    override fun getItemViewType(position: Int): Int = when (rows[position]) {
        is SectionRow -> TYPE_SECTION
        is NumberRow -> TYPE_NUMBER
        is TipRow -> TYPE_TIP
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_SECTION -> SectionHolder(ItemEmergencySectionBinding.inflate(inflater, parent, false))
            TYPE_NUMBER -> NumberHolder(ItemEmergencyBinding.inflate(inflater, parent, false))
            else -> TipHolder(ItemEmergencyTipBinding.inflate(inflater, parent, false))
        }
    }

    override fun getItemCount(): Int = rows.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val row = rows[position]) {
            is SectionRow -> (holder as SectionHolder).bind(row.title)
            is NumberRow -> (holder as NumberHolder).bind(row.number)
            is TipRow -> (holder as TipHolder).bind(row.tip)
        }
    }

    private inner class SectionHolder(
        private val binding: ItemEmergencySectionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(title: String) {
            binding.emergencySectionTitle.text = title
        }
    }

    private inner class NumberHolder(
        private val binding: ItemEmergencyBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(number: EmergencyNumber) {
            binding.emergencyName.text = number.name
            binding.emergencyNumber.text = number.number
            binding.emergencyDesc.text = number.desc
            binding.btnCall.setOnClickListener {
                onCallRequested(number.number)
            }
        }
    }

    private inner class TipHolder(
        private val binding: ItemEmergencyTipBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tip: EmergencyTip) {
            binding.tipTitle.text = tip.title
            binding.tipLine.text = tip.line
        }
    }

    companion object {
        private const val TYPE_SECTION = 0
        private const val TYPE_NUMBER = 1
        private const val TYPE_TIP = 2
    }
}
