package com.oqq.orderqquickly.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.oqq.orderqquickly.R
import com.oqq.orderqquickly.databinding.FragmentRecipeAllDetailPageBinding

class FragmentRecipeAllDetailPage: Fragment() {
    private lateinit var binding:FragmentRecipeAllDetailPageBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeAllDetailPageBinding.inflate(inflater,container,false)
        setBehavior()
        return binding.root
    }

    private fun setBehavior() {
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_recipe_all_dest_to_fragment_recipe_all_detail_dest,null)
        }
    }
}