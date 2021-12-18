package com.saehyun.trigris_android.feature.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.trigris_android.R
import com.saehyun.trigris_android.databinding.ActivityLoginBinding
import com.saehyun.trigris_android.feature.main.ui.MainActivity

class LoginActivity : BaseActivity<ActivityLoginBinding> (
    R.layout.activity_login
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding.tvLogin.setOnClickListener {
            login()
        }

    }

    override fun observeEvent() {
    }

    private fun login() {
        val id = binding.etLoginId.text.toString()
        val pw = binding.etLoginPw.text.toString()

        if(id.isNotEmpty() && pw.isNotEmpty()) {
            startMain()
        } else {
            showToast("아이디 또는 비밀번호를 입력해주세요.")
        }
    }

    private fun startMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}