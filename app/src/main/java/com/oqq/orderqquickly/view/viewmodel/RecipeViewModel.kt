package com.oqq.orderqquickly.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oqq.orderqquickly.data.model.recipe.RecipeResponse
import com.oqq.orderqquickly.repo.BaseResponse
import com.oqq.orderqquickly.repo.Repository
import com.oqq.orderqquickly.repo.ResponseError
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class RecipeViewModel(private val repository: Repository) :ViewModel(){
    private val _success = MutableSharedFlow<Any>()
    val success:SharedFlow<Any> get() = _success

    private val _loading = MutableSharedFlow<Any>()
    val loading:SharedFlow<Any> get() = _loading

    var currentListRecipe:RecipeResponse? = null

    fun getListRecipe(){
        viewModelScope.launch {
            _loading.emit(true)

            when(val result = repository.getListRecipe()){
                is BaseResponse.Success -> {
                    result.data.let {
                        currentListRecipe = it
                    }
                    _success.emit(true)
                    _loading.emit(false)
                }
                is BaseResponse.Error ->{
                    _success.emit((result.exception as ResponseError).msg)
                    _loading.emit(false)
                }
                else -> {}
            }
        }
    }
}