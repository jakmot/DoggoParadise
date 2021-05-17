package jakmot.com.doggoparadise.di

import jakmot.com.doggoparadise.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun appModule() = module {
    viewModel { MainViewModel() }
}