package com.saehyun.trigris_android.di

import android.app.Application
import com.saehyun.trigris_android.di.module.findModule
import com.saehyun.trigris_android.di.module.loginModule
import com.saehyun.trigris_android.di.module.registerModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Container: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Container)

            modules(
                listOf(
                    loginModule,
                    registerModule,
                    findModule
                )
            )
        }
    }
}