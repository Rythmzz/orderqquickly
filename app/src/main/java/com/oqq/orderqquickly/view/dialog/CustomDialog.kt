package com.oqq.orderqquickly.view.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import com.oqq.orderqquickly.listener.DialogResultListener
import com.oqq.orderqquickly.databinding.CustomDialogBinding

class CustomDialog(context:Context, private val dialogResultListener: DialogResultListener, val title:String, val body:String) : Dialog(context) {
    init {
        setCancelable(false)
    }
    private lateinit var binding:CustomDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = CustomDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setIntialData()
        setBehavior()
    }

    private fun setIntialData() {
        binding.tvTitle.setText(title)
        binding.tvBody.setText(body)
    }

    private fun setBehavior() {
        binding.btnYes.setOnClickListener {
            dialogResultListener.onDialogResult(true)
            this.dismiss()
        }
        binding.btnNo.setOnClickListener {
            dialogResultListener.onDialogResult(false)
            this.dismiss()
        }
    }
}