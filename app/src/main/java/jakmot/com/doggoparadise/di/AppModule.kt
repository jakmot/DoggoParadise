package jakmot.com.doggoparadise.di

import jakmot.com.doggoparadise.api.DogCeoService
import jakmot.com.doggoparadise.gallery.GalleryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun appModule() = module {
    viewModel { GalleryViewModel(get()) }
    single { DogCeoService.create() }
}