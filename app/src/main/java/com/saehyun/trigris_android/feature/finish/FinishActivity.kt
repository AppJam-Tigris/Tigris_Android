package com.saehyun.trigris_android.feature.finish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.trigris_android.R
import com.saehyun.trigris_android.databinding.ActivityFindBinding
import com.saehyun.trigris_android.databinding.ActivityFinishBinding
import com.saehyun.trigris_android.feature.main.ui.MainActivity
import hospital

class FinishActivity : BaseActivity<ActivityFinishBinding>(
    R.layout.activity_finish
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setData()

        binding.tvFinish.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }

    override fun observeEvent() {
     }

    private fun setData() {
        binding.tvHospital.text = hospital
    }
}