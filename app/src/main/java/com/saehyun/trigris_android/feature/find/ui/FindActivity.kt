package com.saehyun.trigris_android.feature.find.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nms_android_v1.base.BaseActivity
import com.saehyun.trigris_android.R
import com.saehyun.trigris_android.databinding.ActivityFindBinding
import com.saehyun.trigris_android.feature.document.DocumentActivity
import com.saehyun.trigris_android.feature.find.adapter.ClinicAdapter
import com.saehyun.trigris_android.feature.find.model.ClinicResponseItem
import com.saehyun.trigris_android.feature.find.viewmodel.FindViewModel
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.IOException
import java.net.SocketException

class FindActivity : BaseActivity<ActivityFindBinding> (
    R.layout.activity_find
) {
    private val vm: FindViewModel by viewModel()

    private var clinicList = arrayListOf<ClinicResponseItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        RxJavaPlugins.setErrorHandler { e ->
            var error = e
            if (error is UndeliverableException) {
                error = e.cause
            }
            if (error is IOException || error is SocketException) {
                return@setErrorHandler
            }
            if (error is InterruptedException) {
                return@setErrorHandler
            }
            if (error is NullPointerException || error is IllegalArgumentException) {
                Thread.currentThread().uncaughtExceptionHandler
                    .uncaughtException(Thread.currentThread(), error)
                return@setErrorHandler
            }
            if (error is IllegalStateException) {
                Thread.currentThread().uncaughtExceptionHandler
                    .uncaughtException(Thread.currentThread(), error)
                return@setErrorHandler
            }
            Log.w("Undeliverable exception received, not sure what to do", error)
        }

        binding.rvList.layoutManager= LinearLayoutManager(this)
        binding.rvList.setHasFixedSize(true)
        binding.rvList.adapter= ClinicAdapter(applicationContext, clinicList)

        binding.stvFind.setOnClickListener {
            startActivity(Intent(applicationContext, DocumentActivity::class.java))
        }

        vm.getClinic()
    }

    private fun setClinic(clinicResponseItem: List<ClinicResponseItem>){
        clinicList.clear()
        for(i: Int in 1..50) {
            clinicList.add(clinicResponseItem.get(i))
        }
        binding.rvList.adapter?.notifyDataSetChanged()
    }

    override fun observeEvent() {
        vm.run {
            clinicData.observe(this@FindActivity, {
                setClinic(it)
            })
        }
    }
}