package com.saehyun.trigris_android.di.module

import com.saehyun.trigris_android.data.login.LoginRepository
import com.saehyun.trigris_android.feature.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    single { LoginRepository() }
    viewModel { LoginViewModel(get()) }
}
