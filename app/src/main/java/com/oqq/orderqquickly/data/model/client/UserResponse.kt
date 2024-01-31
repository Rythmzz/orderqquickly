package com.oqq.orderqquickly.data.model.client

data class UserResponse(val jwt:String, val username:String,
val email:String, val firstName:String, val lastName:String, var idMode:Int, var imgAvatar:String ) {

}