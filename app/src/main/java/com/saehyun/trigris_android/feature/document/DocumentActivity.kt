package com.saehyun.trigris_android.feature.document

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.saehyun.trigris_android.R
import com.saehyun.trigris_android.feature.finish.FinishActivity

class DocumentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_document)

        findViewById<TextView>(R.id.sstvFind).setOnClickListener {
            startActivity(Intent(applicationContext, FinishActivity::class.java))
        }

        findViewById<TextView>(R.id.textView15).setOnClickListener {
            findViewById<TextView>(R.id.textView15).background = ContextCompat.getDrawable(this, R.drawable.bg_finish_stoke_border)
        }

        findViewById<TextView>(R.id.textView14).setOnClickListener {
            findViewById<TextView>(R.id.textView14).background = ContextCompat.getDrawable(this, R.drawable.bg_finish_stoke_border)
        }

        findViewById<TextView>(R.id.textView12).setOnClickListener {
            findViewById<TextView>(R.id.textView12).background = ContextCompat.getDrawable(this, R.drawable.bg_finish_stoke_border)
        }
    }
}