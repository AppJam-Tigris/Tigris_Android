package com.saehyun.trigris_android.data.login

import com.saehyun.trigris_android.feature.login.model.LoginRequest
import com.saehyun.trigris_android.feature.login.model.LoginResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST("user/auth")
    fun login(
        @Body loginRequest: LoginRequest
    ) : Single<Response<LoginResponse>>
}