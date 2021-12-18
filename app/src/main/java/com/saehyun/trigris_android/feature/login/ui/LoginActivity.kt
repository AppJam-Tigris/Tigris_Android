package com.saehyun.trigris_android.feature.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.trigris_android.R
import com.saehyun.trigris_android.databinding.ActivityLoginBinding
import com.saehyun.trigris_android.feature.login.model.LoginRequest
import com.saehyun.trigris_android.feature.login.viewmodel.LoginViewModel
import com.saehyun.trigris_android.feature.main.ui.MainActivity
import com.saehyun.trigris_android.feature.register.ui.RegisterActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding> (
    R.layout.activity_login
) {

    val vm: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.tvLogin.setOnClickListener {
            login()
        }

        binding.tvRegister.setOnClickListener {
            register()
        }
    }

    override fun observeEvent() {
        vm.run {
            success.observe(this@LoginActivity, {
                showToast("로그인에 성공했습니다.")
                startMain()
            })
            failed.observe(this@LoginActivity, {
                showToast("아이디 또는 비밀번호가 일치하지 않습니다!")
            })
        }
    }

    private fun login() {
        val id = binding.etLoginId.text.toString()
        val pw = binding.etLoginPw.text.toString()

        if(id.isNotEmpty() && pw.isNotEmpty()) {
            vm.login(LoginRequest(id, pw))
//            startMain()
        } else {
            showToast("아이디 또는 비밀번호를 입력해주세요.")
        }
    }

    private fun startMain() {
        startActivity(Intent(applicationContext, MainActivity::class.java))
    }

    private fun register() {
        startActivity(Intent(applicationContext, RegisterActivity::class.java))
    }
}