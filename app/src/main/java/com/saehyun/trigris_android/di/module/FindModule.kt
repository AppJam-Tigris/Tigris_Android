package com.saehyun.trigris_android.di.module

import com.saehyun.trigris_android.data.find.FindRepository
import com.saehyun.trigris_android.feature.find.viewmodel.FindViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val findModule = module {
    single { FindRepository() }
    viewModel { FindViewModel(get()) }
}
