package jakmot.com.doggoparadise.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jakmot.com.doggoparadise.api.DogImage
import jakmot.com.doggoparadise.api.DogImageRepository
import jakmot.com.doggoparadise.common.Event
import jakmot.com.doggoparadise.error.ErrorHandler
import kotlinx.coroutines.launch

class GalleryViewModel(
    private val dogImageRepository: DogImageRepository,
    private val errorHandler: ErrorHandler,
) : ViewModel() {

    private val dogsImages = MutableLiveData<List<DogImage>>()

    private val showError = MutableLiveData<Event<Boolean>>()

    fun getDogsImages(): LiveData<List<DogImage>> = dogsImages

    fun shouldShowError(): LiveData<Event<Boolean>> = showError

    fun init() {
        viewModelScope.launch {
            try {
                val response = dogImageRepository.getRandomImages(50)
                dogsImages.postValue(response)
            } catch (throwable: Throwable) {
                errorHandler.error(throwable)
                showError.value = Event(true)
            }
        }
    }
}