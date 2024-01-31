package com.oqq.orderqquickly.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.oqq.orderqquickly.R
import com.oqq.orderqquickly.databinding.FragmentMyFavoriteRecipePageBinding

class FragmentMyFavoriteRecipePage: Fragment() {
    private lateinit var binding:FragmentMyFavoriteRecipePageBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyFavoriteRecipePageBinding.inflate(inflater,container,false)
        setIntialData()
        setBahavior()
        return binding.root
    }

    private fun setIntialData() {
        bottomNavigationView = activity!!.findViewById(R.id.bn_bottom)
        bottomNavigationView.visibility = View.GONE
    }

    private fun setBahavior() {
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_back_home,null)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bottomNavigationView.visibility = View.VISIBLE
    }
}