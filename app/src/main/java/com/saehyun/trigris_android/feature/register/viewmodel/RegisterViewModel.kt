package com.saehyun.trigris_android.feature.register.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saehyun.trigris_android.data.register.RegisterRepository
import com.saehyun.trigris_android.feature.register.model.IdCheckRequest
import com.saehyun.trigris_android.feature.register.model.Location
import com.saehyun.trigris_android.feature.register.model.PhoneCheckRequest
import com.saehyun.trigris_android.feature.register.model.RegisterRequest

class RegisterViewModel(
    private val rp: RegisterRepository
) : ViewModel() {

    val registerSuccess : MutableLiveData<Boolean> = MutableLiveData()
    val registerFailed : MutableLiveData<String> = MutableLiveData()

    val idCheckSuccess : MutableLiveData<Boolean> = MutableLiveData()
    val idCheckFailed : MutableLiveData<String> = MutableLiveData()

    val phoneCheckSuccess : MutableLiveData<Boolean> = MutableLiveData()
    val phoneCheckFailed : MutableLiveData<String> = MutableLiveData()

    fun register(registerRequest: RegisterRequest) {
        rp.register(registerRequest).subscribe { response ->
            if(response.isSuccessful) {
                registerSuccess.value = true
            } else {
                when(response.code()) {
                    400 -> registerFailed.value = "회원가입 데이터가 올바르지 않습니다."
                    401 -> registerFailed.value = "인증번호가 올바르지 않습니다."
                    409 -> registerFailed.value = "닉네임 또는 이메일 또는 (학번, 이름)가 이미 존재합니다."
                    else -> idCheckFailed.value = "데이터 통신에 실패했습니다.\n다시 시도해주세요."
                }
            }
        }
    }

    fun idCheck(uid: String) {
        val idCheckRequest = IdCheckRequest(uid)
        rp.idCheck(idCheckRequest).subscribe { response ->
            if(response.isSuccessful) {
                idCheckSuccess.value = true
            } else {
                when(response.code()) {
                    409 -> idCheckFailed.value = "이미 존재하는 계정입니다."
                    else -> idCheckFailed.value = "데이터 통신에 실패했습니다.\n다시 시도해주세요."
                }
            }
        }
    }

    fun phoneCheck(phoneNumber: String) {
        val phoneCheckRequest = PhoneCheckRequest(phoneNumber)
        rp.phoneCheck(phoneCheckRequest).subscribe { response ->
            if(response.isSuccessful) {
                phoneCheckSuccess.value = true
            } else {
                when(response.code()) {
                    else -> phoneCheckFailed.value = "데이터 통신에 실패했습니다.\n다시 시도해주세요."
                }
            }
        }
    }
}