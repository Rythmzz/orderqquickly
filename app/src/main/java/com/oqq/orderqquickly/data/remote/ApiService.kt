package com.oqq.orderqquickly.data.remote

import com.oqq.orderqquickly.data.model.client.*
import com.oqq.orderqquickly.data.model.recipe.RecipeResponse
import okhttp3.ResponseBody
import retrofit2.http.POST
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET


interface ApiService {
    @POST("/api/auth/local/register")
    suspend fun createAccount(@Body body:UserData) : Response<ResponseBody>
    @FormUrlEncoded
    @POST("/api/auth/local")
    suspend fun login(
        @Field("identifier") username:String,
    @Field("password") password:String): UserResponse

    @GET("/api/recipes")
    suspend fun getListRecipe(): RecipeResponse

}