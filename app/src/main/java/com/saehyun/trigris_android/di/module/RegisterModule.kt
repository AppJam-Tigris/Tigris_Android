package com.saehyun.trigris_android.di.module

import com.saehyun.trigris_android.data.register.RegisterRepository
import com.saehyun.trigris_android.feature.register.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val registerModule = module {
    single { RegisterRepository() }
    viewModel { RegisterViewModel(get()) }
}
