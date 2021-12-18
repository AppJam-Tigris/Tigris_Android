package com.saehyun.trigris_android.feature.main.ui

import SEOUL_MAP_URL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.trigris_android.R
import com.saehyun.trigris_android.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding> (
    R.layout.activity_main
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView()
    }

    override fun observeEvent() {}

    private fun webView() {
        binding.mapView.run {
            setWebViewClient(WebViewClient())
            getSettings().setJavaScriptEnabled(true)
            loadUrl(SEOUL_MAP_URL)
        }
    }
}