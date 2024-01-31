package com.oqq.orderqquickly.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.oqq.orderqquickly.R
import com.oqq.orderqquickly.listener.DialogResultListener
import com.oqq.orderqquickly.databinding.FragmentProfilePageBinding
import com.oqq.orderqquickly.view.activity.ActivityRestaurantOwnerPage
import com.oqq.orderqquickly.view.dialog.CustomDialog
import org.koin.android.ext.android.inject

class FragmentProfilePage: Fragment() , DialogResultListener {
    private lateinit var binding:FragmentProfilePageBinding

    private val navOptions:NavOptions by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfilePageBinding.inflate(inflater,container,false)
        setBehavior()
        return binding.root
    }

    private fun setBehavior() {
        binding.ivInfoProfile.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_profile_dest_to_fragment_profile_detail_dest,null,navOptions)
        }

        binding.switchMode.setOnClickListener{
            val customDialog = CustomDialog(activity!!,this,"Trở Thành Chủ Cửa Hàng","Bạn có chắc chắn muốn thay đổi sang quyền chủ cửa hàng không?")
            customDialog.show()
        }
    }

    override fun onDialogResult(result: Boolean) {
        if (result){
            val intent:Intent = Intent(activity, ActivityRestaurantOwnerPage::class.java)
            startActivity(intent)
            activity!!.finish()
        }
        else {
            binding.switchMode.isChecked = false
        }
    }
}