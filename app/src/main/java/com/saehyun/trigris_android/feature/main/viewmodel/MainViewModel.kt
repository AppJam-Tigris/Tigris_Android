package com.saehyun.trigris_android.feature.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saehyun.trigris_android.data.main.MainRepository

class MainViewModel(
    private val mp: MainRepository
) : ViewModel() {

    val success : MutableLiveData<Boolean> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()

//    fun getMain() {
//        mp.getMain().subscribe { response ->
//            if (response.isSuccessful) {
//                success.value = true
//            } else {
//                failed.value = true
//            }
//        }
//    }
}