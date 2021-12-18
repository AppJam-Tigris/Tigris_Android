package com.saehyun.trigris_android.feature.register.model


import com.google.gson.annotations.SerializedName

data class LocationX(
    val address: String,
    @SerializedName("detail_address")
    val detailAddress: String,
    @SerializedName("road_name")
    val roadName: String
)