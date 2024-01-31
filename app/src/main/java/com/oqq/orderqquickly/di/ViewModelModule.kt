package com.oqq.orderqquickly.di

import com.oqq.orderqquickly.view.viewmodel.LoginViewModel
import com.oqq.orderqquickly.view.viewmodel.RecipeViewModel
import com.oqq.orderqquickly.view.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        LoginViewModel(get())
    }

    viewModel {
        RegisterViewModel(get())
    }

    viewModel{
        RecipeViewModel(get())
    }


}