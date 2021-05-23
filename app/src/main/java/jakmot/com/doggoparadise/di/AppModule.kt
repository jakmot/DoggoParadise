package jakmot.com.doggoparadise.di

import jakmot.com.doggoparadise.api.DogCeoService
import jakmot.com.doggoparadise.api.DogImageRepository
import jakmot.com.doggoparadise.error.ErrorHandler
import jakmot.com.doggoparadise.gallery.GalleryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun appModule() = module {
    viewModel { GalleryViewModel(get(), get()) }
    single { ErrorHandler() }
    single { DogCeoService.create(DogCeoService.BASE_URL) }
    single { DogImageRepository(get()) }
}