package com.saehyun.trigris_android.feature.register.model


import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    val name: String,
    @SerializedName("phone_number") val phoneNumber: String,
    @SerializedName("birth_day") val birthDay: String,
    val gender: String,
    val nationality: String,
    val location: Location,
    val uid : String,
    val password: String
)