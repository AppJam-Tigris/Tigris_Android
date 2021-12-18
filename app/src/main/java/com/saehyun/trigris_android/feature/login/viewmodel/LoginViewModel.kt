package com.saehyun.trigris_android.feature.login.viewmodel

import ACCESS_TOKEN
import REFRESH_TOKEN
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saehyun.trigris_android.data.login.LoginRepository
import com.saehyun.trigris_android.feature.login.model.LoginRequest

class LoginViewModel(
    private val rp: LoginRepository
) : ViewModel() {

    val success : MutableLiveData<Boolean> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()

    fun login(loginRequest: LoginRequest) {
        rp.login(loginRequest).subscribe { response ->
            if(response.isSuccessful) {
                ACCESS_TOKEN = "Bearer " + response.body()?.accessToken.toString()
                REFRESH_TOKEN = response.body()?.refreshToken.toString()
                success.value = true
            } else {
                failed.value = true
            }
        }
    }
}