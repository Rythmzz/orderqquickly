package com.oqq.orderqquickly.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.oqq.orderqquickly.R
import com.oqq.orderqquickly.data.model.ArticleSlide
import com.oqq.orderqquickly.data.model.FeatureSlide
import com.oqq.orderqquickly.databinding.ImageFeatureItemBinding
import com.oqq.orderqquickly.databinding.ImageItemBinding
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderFeatureAdapter(private val navOptions: NavOptions, private val fragment:Fragment, private var listFeature:MutableList<FeatureSlide>): SliderViewAdapter<SliderFeatureAdapter.SliderAdapterAddImage>() {
    inner class SliderAdapterAddImage(private val binding: ImageFeatureItemBinding):SliderViewAdapter.ViewHolder(binding.root){
        fun bind(item:FeatureSlide, position:Int){
            binding.title.setText(item.title)
            binding.thumnailLayout.setBackgroundResource(item.image)
            binding.btnInteract.setOnClickListener {
               if (position == 0){
                   fragment.findNavController().navigate(R.id.action_fragment_home_dest_to_fragment_add_recipe_detail_dest,null,navOptions)
               }
            }
        }
    }

    override fun getCount(): Int {
        return listFeature.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterAddImage {
        val binding = ImageFeatureItemBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
        return SliderAdapterAddImage(binding)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterAddImage?, position: Int) {
        val item = listFeature[position]
        viewHolder?.bind(item,position)
    }
}