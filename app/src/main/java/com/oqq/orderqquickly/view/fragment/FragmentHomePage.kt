package com.oqq.orderqquickly.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.oqq.orderqquickly.R
import com.oqq.orderqquickly.adapter.SliderFeatureAdapter
import com.oqq.orderqquickly.data.model.FeatureSlide
import com.oqq.orderqquickly.databinding.FragmentHomePageBinding
import com.oqq.orderqquickly.utils.Keyboard
import org.koin.android.ext.android.inject

class FragmentHomePage: Fragment() {
    private lateinit var binding:FragmentHomePageBinding
    private lateinit var keyboard: Keyboard
    private lateinit var listFeature:MutableList<FeatureSlide>

    private val navOptions: NavOptions by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater,container,false)

        setIntialData()
        setSlideImage()
        setBehavior()
        setFragment()
        setAdapter()
        return binding.root
    }

    private fun setSlideImage() {


    }

    private fun setIntialData() {
        keyboard = Keyboard(activity!!)

        listFeature = mutableListOf(
            FeatureSlide("Thêm công thức cho chính mình ngay bây giờ",R.drawable.shape_07),
            FeatureSlide("Thêm menu cho nhà hàng của riêng mình",R.drawable.img_feature_02)
        )

        binding.sliderFeature.setSliderAdapter(SliderFeatureAdapter(navOptions,this,listFeature))
        binding.sliderFeature.startAutoCycle()
    }

    private fun setAdapter() {
    }

    private fun setFragment() {

    }

    private fun setBehavior() {
        binding.editSearch.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_home_dest_to_fragment_recipe_search_dest,null,navOptions)
        }

        binding.layoutRecommendFood01.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_home_dest_to_fragment_detail_recipe_dest,null,navOptions)
        }

        binding.layoutRecommendFood02.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_home_dest_to_fragment_detail_recipe_dest,null,navOptions)
        }

        binding.layoutHealthyFood01.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_home_dest_to_fragment_detail_recipe_dest,null,navOptions)
        }

        binding.layoutHealthyFood02.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_home_dest_to_fragment_detail_recipe_dest,null,navOptions)
        }
//
//        binding.btnLogin.setOnClickListener {
//            findNavController().navigate(R.id.action_fragment_home_dest_to_fragment_add_recipe_detail_dest,null)
//        }

        binding.textSeeAll01.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_home_dest_to_fragment_recipe_all_dest,null,navOptions)
        }

        binding.textSeeAll02.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_home_dest_to_fragment_recipe_healthy_page,null,navOptions)
            // món có lợi cho sức khỏe
        }

        binding.btnStartCook.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_home_dest_to_fragment_detail_recipe_dest,null,navOptions)
        }

    }
}