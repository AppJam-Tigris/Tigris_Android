package com.saehyun.trigris_android.feature.register.model

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("uid") val nickname : String,
    @SerializedName("password") val name : String
)
