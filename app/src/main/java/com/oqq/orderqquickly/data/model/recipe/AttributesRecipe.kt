package com.oqq.orderqquickly.data.model.recipe

data class AttributesRecipe(val name:String,
val brief:String,
val description:String,
val duration:Int,
val kcal:Int,
val count:Int,
val view:Int, val meal:String,
val ingredients:List<String>,
val process:List<Process>) {
}