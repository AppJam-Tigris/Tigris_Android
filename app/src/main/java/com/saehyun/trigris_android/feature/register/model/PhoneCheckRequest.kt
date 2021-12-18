package com.saehyun.trigris_android.feature.register.model


import com.google.gson.annotations.SerializedName

data class PhoneCheckRequest(
    @SerializedName("phone_number") val phoneNumber: String
)