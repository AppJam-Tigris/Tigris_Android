package com.saehyun.trigris_android.data.register

import com.saehyun.trigris_android.feature.register.model.RegisterRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface RegisterApi {

    // register
    @POST("user")
    fun register(
        @Body registerRequest: RegisterRequest
    ) : Single<Response<Void>>
}