package com.depremhazirlik.app.data

import android.content.Context
import android.content.SharedPreferences

/**
 * Kullanıcının işaretlediği maddeleri SharedPreferences üzerinde saklar.
 */
class ChecklistStore(context: Context) {

    private val prefs: SharedPreferences =
        context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun isChecked(itemId: String): Boolean = prefs.getBoolean(key(itemId), false)

    fun setChecked(itemId: String, checked: Boolean) {
        prefs.edit().putBoolean(key(itemId), checked).apply()
    }

    fun completedCount(): Int {
        var count = 0
        for (item in ChecklistData.items) {
            if (isChecked(item.id)) count++
        }
        return count
    }

    private fun key(itemId: String) = "item_$itemId"

    companion object {
        private const val PREFS_NAME = "deprem_hazirlik"
    }
}
