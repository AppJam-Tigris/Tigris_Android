package com.saehyun.trigris_android.feature.find.viewmodel

import ACCESS_TOKEN
import REFRESH_TOKEN
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saehyun.trigris_android.data.find.FindRepository
import com.saehyun.trigris_android.data.login.LoginRepository
import com.saehyun.trigris_android.feature.find.model.ClinicRequest
import com.saehyun.trigris_android.feature.find.model.ClinicResponse
import com.saehyun.trigris_android.feature.login.model.LoginRequest

class FindViewModel(
    private val fp: FindRepository
) : ViewModel() {

    val clinicData : MutableLiveData<ClinicResponse> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()

    fun getClinic() {
        fp.getClinic().subscribe { response ->
            if(response.isSuccessful) {
                clinicData.value = response.body()
            } else {
                failed.value = true
            }
        }
    }
}