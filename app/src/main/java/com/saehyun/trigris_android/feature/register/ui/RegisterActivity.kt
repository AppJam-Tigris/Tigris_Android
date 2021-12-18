package com.saehyun.trigris_android.feature.register.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.trigris_android.R
import com.saehyun.trigris_android.databinding.ActivityRegisterBinding
import com.saehyun.trigris_android.feature.register.model.Location
import com.saehyun.trigris_android.feature.register.model.RegisterRequest
import com.saehyun.trigris_android.feature.register.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding> (
    R.layout.activity_register
) {

    private val vm: RegisterViewModel by viewModel()

    private var name: String ?= null
    private var phone_number: String ?= null
    private var birth_day: String ?= null
    private var gender: String ?= null
    private var nationality: String ?= null
    private var location: Location ?= null
    private var uid: String ?= null
    private var password: String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observeEvent() {}

    private fun register() {
//        vm.register(RegisterRequest)
    }
}