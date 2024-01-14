package com.oqq.orderqquickly.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.oqq.orderqquickly.databinding.FragmentMenuRestaurantPageBinding

class FragmentMenuRestaurantPage : Fragment() {

    private lateinit var binding:FragmentMenuRestaurantPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuRestaurantPageBinding.inflate(inflater,container,false)
        return binding.root
    }
}