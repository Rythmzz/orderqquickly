package com.oqq.orderqquickly.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.oqq.orderqquickly.R
import com.oqq.orderqquickly.adapter.SliderFeatureAdapter
import com.oqq.orderqquickly.data.model.FeatureSlide
import com.oqq.orderqquickly.data.model.recipe.AttributesRecipe
import com.oqq.orderqquickly.data.model.recipe.RecipeResponse
import com.oqq.orderqquickly.databinding.FragmentHomePageBinding
import com.oqq.orderqquickly.utils.Keyboard
import com.oqq.orderqquickly.view.viewmodel.RecipeViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentHomePage: Fragment() {
    private lateinit var binding:FragmentHomePageBinding
    private lateinit var keyboard: Keyboard
    private lateinit var listFeature:MutableList<FeatureSlide>

    private var firstThread: Job? = null

    private val recipeViewModel:RecipeViewModel by viewModel()

    private val navOptions: NavOptions by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater,container,false)

        setIntialData()
        setSlideImage()
        setStatus()
        setBehavior()
        setFragment()
        setAdapter()
        return binding.root
    }



    private fun setStatus() {
        firstThread = lifecycleScope.launchWhenStarted {
            this.launch {
                recipeViewModel.success.collect{result ->
                    if (result is Boolean && result){
                        val recipes = recipeViewModel.currentListRecipe!!.data
                        binding.textNameHealthyFood01.setText(recipes[0].attributes.name.toString())
                        binding.textNameHealthyFood02.setText(recipes[1].attributes.name.toString())

                        binding.textViewHealthyFood01.setText(recipes[0].attributes.view.toString())
                        binding.textViewHealthyFood02.setText(recipes[1].attributes.view.toString())

                        binding.textDurationHealthyFood01.setText("\uD83D\uDD52 " + recipes[0].attributes.duration.toString()+" phút")
                        binding.textDurationHealthyFood02.setText("\uD83D\uDD52 " +recipes[1].attributes.duration.toString()+" phút")

                        binding.textKcalHealthyFood01.setText(recipes[0].attributes.kcal.toString()+" kcal")
                        binding.textKcalHealthyFood02.setText(recipes[1].attributes.kcal.toString()+ " kcal")

                        binding.textCountHealthyFood01.setText("\uD83D\uDCDD " + recipes[0].attributes.count.toString())
                        binding.textCountHealthyFood02.setText("\uD83D\uDCDD "+ recipes[1].attributes.count.toString())
                    }
                    else {
                        println("Bi loi ${result.toString()}")
                    }
                }
            }
        }
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

        recipeViewModel.getListRecipe()
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