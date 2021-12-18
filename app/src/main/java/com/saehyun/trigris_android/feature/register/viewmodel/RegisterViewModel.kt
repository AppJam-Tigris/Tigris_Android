package com.saehyun.trigris_android.feature.register.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saehyun.trigris_android.data.register.RegisterRepository
import com.saehyun.trigris_android.feature.register.model.Location
import com.saehyun.trigris_android.feature.register.model.RegisterRequest

class RegisterViewModel(
    private val rp: RegisterRepository
) : ViewModel() {

    val success : MutableLiveData<Boolean> = MutableLiveData()
    val failed : MutableLiveData<String> = MutableLiveData()
    val errorMessage : MutableLiveData<String> = MutableLiveData()
    val checkSuccess : MutableLiveData<Boolean> = MutableLiveData()
    val checkFailed : MutableLiveData<Boolean> = MutableLiveData()

    fun register(name: String, phoneNumber: String, birthDay: String, gender: String, nationality: String,
                 location: Location, uid: String, password: String) {
        val registerRequest = RegisterRequest(name, phoneNumber, birthDay, gender, nationality, location, uid, password)
        rp.register(registerRequest).subscribe { response ->
            if(response.isSuccessful) {
                success.value = true
            } else {
                when(response.code()) {
                    409 -> failed.value = "이미 존재하는 계정입니다."
                    else -> failed.value = "회원가입에 실패했습니다."
                }
            }
        }
    }
}