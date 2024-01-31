package com.oqq.orderqquickly.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.oqq.orderqquickly.R
import com.oqq.orderqquickly.databinding.FragmentFoodDetailPageBinding
import org.koin.android.ext.android.inject

class FragmentFoodDetailPage: Fragment() {
    private lateinit var binding:FragmentFoodDetailPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodDetailPageBinding.inflate(inflater,container,false)
        setBehavior()
        return binding.root
    }

    private fun setBehavior() {
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_menu_restaurant_dest_to_fragment_food_detail_dest,null)
        }
    }
}