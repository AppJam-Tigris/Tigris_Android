package com.saehyun.trigris_android.data.register

import com.example.nms_android_v1.di.registerApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class RegisterRepository {

    fun register(registerRequest: RegisterRequest) : @NonNull Single<Response<Void>> =
        registerApi.register(registerRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}