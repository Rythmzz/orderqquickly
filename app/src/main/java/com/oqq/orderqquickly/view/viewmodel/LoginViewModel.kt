package com.oqq.orderqquickly.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oqq.orderqquickly.data.model.client.UserResponse
import com.oqq.orderqquickly.repo.BaseResponse
import com.oqq.orderqquickly.repo.Repository
import com.oqq.orderqquickly.repo.ResponseError
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class LoginViewModel(val repository: Repository):ViewModel() {

    private val _success = MutableSharedFlow<Any>()
    val success:SharedFlow<Any> get() = _success

    private val _loading = MutableSharedFlow<Any>()
    val loading:SharedFlow<Any> get() = _loading

    var user:UserResponse? = null

    fun login(username:String, password:String){
        viewModelScope.launch {
            _loading.emit(true)

            when(val result = repository.login(username,password)){
                is BaseResponse.Success -> {
                    result.data.let {data ->
                        user = data
                    }
                    _success.emit(true)
                }
                is BaseResponse.Error -> {
                    _success.emit((result.exception as ResponseError).msg)
                    _loading.emit(false)
                }
                BaseResponse.Loading -> Unit
            }
        }
    }

}