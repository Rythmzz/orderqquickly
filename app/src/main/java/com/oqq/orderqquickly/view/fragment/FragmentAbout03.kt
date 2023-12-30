package com.oqq.orderqquickly.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.oqq.orderqquickly.databinding.FragmentAbout01Binding
import com.oqq.orderqquickly.databinding.FragmentAbout03Binding

class FragmentAbout03: Fragment() {
    private lateinit var binding : FragmentAbout03Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAbout03Binding.inflate(inflater,container,false)
        return binding.root
    }
}