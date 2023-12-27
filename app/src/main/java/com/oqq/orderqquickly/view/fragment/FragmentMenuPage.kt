package com.oqq.orderqquickly.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.oqq.orderqquickly.databinding.FragmentMenuPageBinding

class FragmentMenuPage: Fragment() {
    private lateinit var binding:FragmentMenuPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuPageBinding.inflate(inflater,container,false)
        return binding.root
    }
}