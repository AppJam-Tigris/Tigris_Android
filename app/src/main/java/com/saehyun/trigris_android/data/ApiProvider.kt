package com.example.nms_android_v1.di

import BASE_URL
import com.saehyun.trigris_android.data.find.FindApi
import com.saehyun.trigris_android.data.login.LoginApi
import com.saehyun.trigris_android.data.main.MainApi
import com.saehyun.trigris_android.data.register.RegisterApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl(BASE_URL)
    addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    addConverterFactory(GsonConverterFactory.create())
}.build()

val LOGIN_API : LoginApi by lazy {
    retrofit.create(LoginApi::class.java)
}

val registerApi : RegisterApi by lazy {
    retrofit.create(RegisterApi::class.java)
}

val mainApi : MainApi by lazy {
    retrofit.create(MainApi::class.java)
}

val findApi : FindApi by lazy {
    retrofit.create(FindApi::class.java)
}