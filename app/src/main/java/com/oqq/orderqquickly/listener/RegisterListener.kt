package com.oqq.orderqquickly.listener

import androidx.navigation.NavController

interface RegisterListener {
    fun registerOnListener(result:Boolean, navController: NavController)
}