package com.saehyun.trigris_android.data.register

import com.saehyun.trigris_android.feature.register.model.IdCheckRequest
import com.saehyun.trigris_android.feature.register.model.PhoneCheckRequest
import com.saehyun.trigris_android.feature.register.model.RegisterRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {

    // 회원가입
    @POST("user")
    fun register(
        @Body registerRequest: RegisterRequest
    ) : Single<Response<Void>>

    // 전화번호 인증번호 발송
    @POST("user/home")
    fun phoneCheck(
        @Body phoneCheckRequest: PhoneCheckRequest
    ) : Single<Response<Void>>

    // 아이디 중복 확인
    @POST("user/duplicate")
    fun idCheck(
        @Body idCheckRequest: IdCheckRequest
    ) : Single<Response<Void>>
}