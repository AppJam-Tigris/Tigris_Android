package com.saehyun.trigris_android.feature.register.model


import com.google.gson.annotations.SerializedName

data class GetInfoResponse(
    @SerializedName("birth_day")
    val birthDay: String,
    val gender: String,
    val location: LocationX,
    val name: String,
    val nationality: String,
    @SerializedName("phone_number")
    val phoneNumber: String
)