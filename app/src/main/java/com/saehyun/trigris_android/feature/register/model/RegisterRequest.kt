package com.saehyun.trigris_android.feature.register.model

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("nickname") val nickname : String,
    @SerializedName("name") val name : String,
    @SerializedName("grade") val grade : String,
    @SerializedName("class_num") val class_num : String,
    @SerializedName("number") val number : String,
    @SerializedName("password") val password : String,
    @SerializedName("email") val email : String
)
