package com.saehyun.trigris_android.feature.register.ui

import DAUM_URL
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.trigris_android.R
import com.saehyun.trigris_android.databinding.ActivityAddressBinding
import android.app.Activity
import android.view.View


class AddressActivity : AppCompatActivity() {

    companion object {
        const val ADDRESS_REQUEST_CODE = 2928
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        val webView = findViewById<WebView>(R.id.web_view)

        webView.settings.javaScriptEnabled = true

        webView.addJavascriptInterface(KaKaoJavaScriptInterface(), "Android")
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                webView.loadUrl("javascript:execKakaoPostcode();")
            }
        }
        
        webView.loadUrl(DAUM_URL)
    }

    inner class KaKaoJavaScriptInterface {

        @JavascriptInterface
        fun processDATA(address: String?) {
            Intent().apply {
                putExtra("address", address)
                setResult(RESULT_OK, this)
            }
            finish()
        }
    }
}