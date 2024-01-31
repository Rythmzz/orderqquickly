package com.oqq.orderqquickly.repo

data class ResponseError(
    val code:Int,
    val msg:String,
) : RuntimeException(), java.io.Serializable{
}