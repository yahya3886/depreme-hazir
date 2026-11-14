package com.depremhazirlik.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.depremhazirlik.app.databinding.ActivityMainBinding
import com.depremhazirlik.app.ui.AboutFragment
import com.depremhazirlik.app.ui.ChecklistFragment
import com.depremhazirlik.app.ui.EmergencyFragment
import com.depremhazirlik.app.ui.GuideFragment
import com.depremhazirlik.app.ui.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = getString(R.string.app_name)

        binding.bottomNav.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_checklist -> ChecklistFragment()
                R.id.nav_guide -> GuideFragment()
                R.id.nav_emergency -> EmergencyFragment()
                R.id.nav_about -> AboutFragment()
                else -> return@setOnItemSelectedListener false
            }
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.fragmentContainer, fragment)
                .commit()
            true
        }

        if (savedInstanceState == null) {
            binding.bottomNav.selectedItemId = R.id.nav_home
        }
    }

    /** Fragment'ların alt menüdeki sekmeye geçmesi için kullanılır. */
    fun openTab(itemId: Int) {
        binding.bottomNav.selectedItemId = itemId
    }
}
