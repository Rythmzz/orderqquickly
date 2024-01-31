package com.oqq.orderqquickly.view.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.oqq.orderqquickly.R
import com.oqq.orderqquickly.databinding.ActivityMainPageBinding
import com.oqq.orderqquickly.databinding.ActivityRestaurantOwnerPageBinding

class ActivityRestaurantOwnerPage: AppCompatActivity() {
    private lateinit var binding:ActivityRestaurantOwnerPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantOwnerPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.statusBarColor = Color.parseColor("#000000")
//        }

        val navHost: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
                ?: return

        val navController = navHost.navController

        setupNavigationMenu(navController)

        binding.bnBottom.setupWithNavController(navController)
    }


    private fun setupNavigationMenu(navController:NavController){
        val sideNavView = findViewById<NavigationView>(R.id.nav_view)
        sideNavView?.setupWithNavController(navController)
    }
}