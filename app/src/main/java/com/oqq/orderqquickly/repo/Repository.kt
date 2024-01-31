package com.oqq.orderqquickly.repo

import com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
import com.oqq.orderqquickly.data.model.client.*
import com.oqq.orderqquickly.data.model.recipe.RecipeResponse
import com.oqq.orderqquickly.data.remote.ApiService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class Repository(private val api:ApiService) {

    suspend fun getListRecipe():BaseResponse<RecipeResponse>{
        return try{
            BaseResponse.Success(api.getListRecipe())
        }
        catch (ex:Exception){
            return BaseResponse.Error(ResponseError(101,ex.message.toString()))
        }
    }

    suspend fun login(username:String, password:String): BaseResponse<UserResponse>{
        return try{
            BaseResponse.Success(api.login(username,password))
        }
        catch (ex:Exception){
            return BaseResponse.Error(ResponseError(101,ex.message.toString()))
        }
    }

    suspend fun register(userData: UserData) : BaseResponse<Any> {

        try {
            val response = api.createAccount(userData)
            if (response.isSuccessful){
                return BaseResponse.Success<UserData>(userData)
            }
            else {
                return BaseResponse.Error(ResponseError(101,response.message().toString()))
            }
        }
        catch (ex:Exception){
            return BaseResponse.Error(ResponseError(101,ex.message.toString()))
        }
    }

}