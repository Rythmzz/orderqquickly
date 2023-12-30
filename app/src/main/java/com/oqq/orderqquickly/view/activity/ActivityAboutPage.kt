package com.oqq.orderqquickly.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.oqq.orderqquickly.ActivityMainPage
import com.oqq.orderqquickly.R
import com.oqq.orderqquickly.databinding.ActivityAboutPageBinding
import com.oqq.orderqquickly.view.fragment.FragmentAbout01
import com.oqq.orderqquickly.view.fragment.FragmentAbout02
import com.oqq.orderqquickly.view.fragment.FragmentAbout03

class ActivityAboutPage: AppCompatActivity() {
    private lateinit var binding:ActivityAboutPageBinding
    private lateinit var fragments:ArrayList<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitleUI()
        setFragment()
        setAdapter()
        setBehavior()

    }

    private fun setBehavior() {
        binding.next.setOnClickListener {
            if (binding.viewPager.currentItem == fragments.size -1){
                val intent: Intent = Intent(this,ActivityMainPage::class.java)
                startActivity(intent)
                finish()
            }
            else{
                binding.viewPager.setCurrentItem(binding.viewPager.currentItem + 1,true)
            }
        }
    }

    private fun setAdapter() {
        val adapterViewPage = object: FragmentStateAdapter(this){
            override fun getItemCount(): Int {
               return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
               return fragments[position]
            }

        }
        binding.viewPager.adapter = adapterViewPage
        binding.dosIndicator.setViewPager2(binding.viewPager)
    }

    private fun setFragment() {
        fragments = arrayListOf(
            FragmentAbout01(),FragmentAbout02(), FragmentAbout03()
        )
    }

    private fun setTitleUI() {
        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.main_color_01)
    }
}