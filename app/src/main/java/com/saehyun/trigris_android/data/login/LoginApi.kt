package com.saehyun.trigris_android.data.login

import com.saehyun.trigris_android.feature.login.model.LoginRequest
import com.saehyun.trigris_android.feature.login.model.LoginResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginApi {

    // 로그인
    @POST("user/auth")
    fun login(
        @Body loginRequest: LoginRequest
    ) : Single<Response<LoginResponse>>

    // 회원정보 불러오기
    @GET("user")
    fun getInfo(
        @Header("Authorization") accessToken: String
    ) : Single<Response<LoginResponse>>
}