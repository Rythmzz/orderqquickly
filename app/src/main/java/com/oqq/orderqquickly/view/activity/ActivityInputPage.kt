package com.oqq.orderqquickly.view.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.oqq.orderqquickly.R
import com.oqq.orderqquickly.databinding.ActivityInputPageBinding

class ActivityInputPage: AppCompatActivity() {

    private lateinit var binding:ActivityInputPageBinding
    private var isLogin:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
                ?: return

        val navControll = navHost.navController

        setAction(navControll)
    }

    private fun setAction(navController: NavController) {
        binding.labelLogin.setOnClickListener {
            if (!isLogin){
                binding.textHeader.text = "Sign In"
                binding.textLbLogin.setTextColor(Color.parseColor("#FFA500"))
                binding.textLbRegister.setTextColor(Color.parseColor("#A6A6A6"))
                binding.dividerOfLogin.visibility = View.VISIBLE
                binding.dividerOfRegister.visibility = View.GONE
                isLogin = true

                navController.navigate(R.id.action_fragment_login_dest_to_fragment_register_dest,null)

            }

        }

        binding.labelRegister.setOnClickListener {
            if (isLogin){
                binding.textHeader.text = "Sign Up"
                binding.textLbRegister.setTextColor(Color.parseColor("#FFA500"))
                binding.textLbLogin.setTextColor(Color.parseColor("#A6A6A6"))
                binding.dividerOfLogin.visibility = View.GONE
                binding.dividerOfRegister.visibility = View.VISIBLE
                isLogin = false

                navController.navigate(R.id.action_fragment_login_dest_to_fragment_register_dest,null)
            }
        }
    }

}