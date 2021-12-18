package com.saehyun.trigris_android.feature.find.model


import com.google.gson.annotations.SerializedName

data class ClinicResponseItem(
    val address: String,
    val city: String,
    @SerializedName("clinic_id")
    val clinicId: Int,
    @SerializedName("manager_phone_number")
    val managerPhoneNumber: String,
    val name: String
)