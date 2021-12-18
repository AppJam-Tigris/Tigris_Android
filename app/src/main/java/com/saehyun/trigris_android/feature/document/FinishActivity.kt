package com.saehyun.trigris_android.feature.document

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.saehyun.trigris_android.R
import com.saehyun.trigris_android.feature.main.ui.MainActivity

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        findViewById<ImageView>(R.id.imageView44).setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }
}