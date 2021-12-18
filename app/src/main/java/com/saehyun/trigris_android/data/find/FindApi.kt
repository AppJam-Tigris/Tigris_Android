package com.saehyun.trigris_android.data.find

import com.saehyun.trigris_android.feature.find.model.ClinicRequest
import com.saehyun.trigris_android.feature.find.model.ClinicResponse
import com.saehyun.trigris_android.feature.login.model.LoginRequest
import com.saehyun.trigris_android.feature.login.model.LoginResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface FindApi {

    // 선별진료소 추천
    @GET("clinic")
    fun getClinic(
        @Header("Authorization") accessToken: String,
    ) : Single<Response<ClinicResponse>>

    // 선별진료소 검색
    @GET("clinic/search")
    fun getClinicSearch(
        @Body clinicRequest: ClinicRequest,
        @Header("Authorization") accessToken: String
    ) : Single<Response<ClinicResponse>>
}