package com.saehyun.trigris_android.data.find

import ACCESS_TOKEN
import com.example.nms_android_v1.di.LOGIN_API
import com.example.nms_android_v1.di.findApi
import com.saehyun.trigris_android.feature.find.model.ClinicRequest
import com.saehyun.trigris_android.feature.find.model.ClinicResponse
import com.saehyun.trigris_android.feature.login.model.LoginRequest
import com.saehyun.trigris_android.feature.login.model.LoginResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class FindRepository {

    fun getClinic() : @NonNull Single<Response<ClinicResponse>> =
        findApi.getClinic(ACCESS_TOKEN)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

}