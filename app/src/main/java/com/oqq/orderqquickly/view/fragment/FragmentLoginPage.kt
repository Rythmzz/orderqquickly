package com.oqq.orderqquickly.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.oqq.orderqquickly.databinding.FragmentLoginPageBinding

class FragmentLoginPage: Fragment() {

    private lateinit var binding:FragmentLoginPageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginPageBinding.inflate(inflater,container,false)
        return binding.root
    }
}