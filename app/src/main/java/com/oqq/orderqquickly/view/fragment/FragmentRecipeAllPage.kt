package com.oqq.orderqquickly.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.oqq.orderqquickly.R
import com.oqq.orderqquickly.databinding.FragmentRecipeAllPageBinding
import org.koin.android.ext.android.inject

class FragmentRecipeAllPage: Fragment() {
    private lateinit var binding:FragmentRecipeAllPageBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private val navOptions:NavOptions by inject()

    private lateinit var listLayout:MutableList<FrameLayout>



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeAllPageBinding.inflate(inflater,container,false)

        setIntialData()
        setBehavior()
        return binding.root
    }

    private fun setBehavior() {
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_home_dest_to_fragment_recipe_all_dest,null)
        }

        for (i in listLayout){
            i.setOnClickListener {
                findNavController().navigate(R.id.action_fragment_recipe_all_dest_to_fragment_recipe_all_detail_dest,null,navOptions)
            }
        }



    }

    private fun setIntialData() {
        bottomNavigationView = activity!!.findViewById(R.id.bn_bottom)
        bottomNavigationView.visibility = View.GONE

        listLayout = mutableListOf(
            binding.layoutBreakfast,binding.layoutLunch,binding.layoutDinner
        )
    }


    override fun onDestroy() {
        super.onDestroy()
        bottomNavigationView.visibility = View.VISIBLE
    }
}