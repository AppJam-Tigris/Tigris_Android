package com.saehyun.trigris_android.feature.login.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("uid") val email: String,
    @SerializedName("password") val password: String
)
