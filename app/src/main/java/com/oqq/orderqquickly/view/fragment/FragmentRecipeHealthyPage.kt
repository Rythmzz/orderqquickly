package com.oqq.orderqquickly.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.oqq.orderqquickly.R
import com.oqq.orderqquickly.adapter.SliderAdapter
import com.oqq.orderqquickly.data.model.ArticleSlide
import com.oqq.orderqquickly.databinding.FragmentRecipeHealthyPageBinding

class FragmentRecipeHealthyPage: Fragment() {
    private lateinit var binding:FragmentRecipeHealthyPageBinding
    private lateinit var imageList: MutableList<ArticleSlide>
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeHealthyPageBinding.inflate(inflater)

        setIntialData()
        setSliderImage()
        setBehavior()
        return binding.root
    }

    private fun setBehavior() {
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_home_dest_to_fragment_recipe_healthy_page,null)
        }
    }

    private fun setIntialData() {
        bottomNavigationView = activity!!.findViewById(R.id.bn_bottom)
        bottomNavigationView.visibility = View.GONE
    }

    private fun setSliderImage() {
        imageList = mutableListOf(
            ArticleSlide("https://thermomixvietnam.vn/blog/xu-huong-nha-bep/dinh-duong-bua-an-lanh-manh.html","https://thermomixvietnam.vn/wp-content/uploads/2021/08/lua-mach-khoai-mi-cung-cao-dinh-duong-bua-an-lanh-manh.jpg","Dinh dưỡng bữa ăn lành mạnh","việc quan tâm đến dinh dưỡng bữa ăn lành mạnh là điều hết sức cần thiết để bạn cải thiện các vấn đề về cân nặng và sức khỏe của bản thân."),
            ArticleSlide("https://laodong.vn/suc-khoe/12-mon-an-nhe-lanh-manh-va-tot-cho-suc-khoe-937033.ldo","https://media-cdn-v2.laodong.vn/storage/newsportal/2021/8/1/937033/1.jpg?w=660","12 món ăn nhẹ lành mạnh","Lựa chọn đồ ăn nhẹ bổ dưỡng để thưởng thức suốt cả ngày là điều rất quan trọng của bất kỳ chế độ ăn uống lành mạnh nào"),
            ArticleSlide("https://www.sapo.vn/blog/do-an-healthy-cho-loi-song-lanh-manh","https://blog.dktcdn.net/files/mon-an-healthy.png","Gợi ý những đồ ăn healthy","Đồ ăn healthy đang được nhiều người săn đón vì chúng là những thực phẩm tốt cho sức khỏe")

        )

        binding.imageSlider.setSliderAdapter(SliderAdapter(imageList))
        binding.imageSlider.startAutoCycle()
    }

    override fun onDestroy() {
        super.onDestroy()
        bottomNavigationView.visibility = View.VISIBLE
    }
}