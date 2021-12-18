package com.saehyun.trigris_android.data.register

import com.example.nms_android_v1.di.registerApi
import com.saehyun.trigris_android.feature.register.model.IdCheckRequest
import com.saehyun.trigris_android.feature.register.model.PhoneCheckRequest
import com.saehyun.trigris_android.feature.register.model.RegisterRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

class RegisterRepository {

    // 회원가입
    fun register(registerRequest: RegisterRequest) : @NonNull Single<Response<Void>> =
        registerApi.register(registerRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    // 전화번호 인증번호 발송
    fun register(phoneCheckRequest: PhoneCheckRequest) : @NonNull Single<Response<Void>> =
        registerApi.phoneCheck(phoneCheckRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    // 아이디 중복 확인
    fun idCheck(idCheckRequest: IdCheckRequest) : @NonNull Single<Response<Void>> =
        registerApi.idCheck(idCheckRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}