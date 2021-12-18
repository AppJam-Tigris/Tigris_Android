package com.saehyun.trigris_android.feature.register.model


import com.google.gson.annotations.SerializedName

data class Location(
    val address: Int,
    @SerializedName("details_address") val detailsAddress: String,
    @SerializedName("road_name") val roadName: String
)