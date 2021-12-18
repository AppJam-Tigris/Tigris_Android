package com.saehyun.trigris_android.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.trigris_android.R
import com.saehyun.trigris_android.databinding.ActivityStartBinding
import com.saehyun.trigris_android.feature.login.ui.LoginActivity
import com.saehyun.trigris_android.feature.main.ui.MainActivity

class StartActivity : BaseActivity<ActivityStartBinding> (
    R.layout.activity_start
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        startLogin()
    }

    override fun observeEvent() {}

    private fun startLogin() {
        startActivity(Intent(applicationContext, LoginActivity::class.java))
    }
}