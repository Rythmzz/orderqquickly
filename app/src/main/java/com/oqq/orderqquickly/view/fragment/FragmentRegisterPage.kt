package com.oqq.orderqquickly.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.oqq.orderqquickly.databinding.FragmentLoginPageBinding
import com.oqq.orderqquickly.databinding.FragmentRegisterPageBinding

class FragmentRegisterPage: Fragment() {

    private lateinit var binding: FragmentRegisterPageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterPageBinding.inflate(inflater,container,false)
        return binding.root
    }
}