package com.oqq.orderqquickly.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.oqq.orderqquickly.R
import com.oqq.orderqquickly.databinding.FragmentMenuPageBinding
import com.oqq.orderqquickly.utils.Keyboard

class FragmentMenuPage: Fragment() {
    private lateinit var binding:FragmentMenuPageBinding
    private lateinit var keyboard: Keyboard

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuPageBinding.inflate(inflater,container,false)

        setIntialData()
        setBehavior()
        return binding.root

    }

    private fun setBehavior() {
        binding.editSearch.setOnClickListener {

            findNavController().navigate(R.id.action_fragment_menu_dest_to_fragment_menu_search_dest,null)
        }
    }

    private fun setIntialData() {
        keyboard = Keyboard(activity!!)
    }
}