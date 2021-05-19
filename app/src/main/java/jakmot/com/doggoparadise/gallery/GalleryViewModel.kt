package jakmot.com.doggoparadise.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jakmot.com.doggoparadise.api.DogImage
import jakmot.com.doggoparadise.api.DogImageRepository
import kotlinx.coroutines.launch

class GalleryViewModel(
    private val dogImageRepository: DogImageRepository,
) : ViewModel() {

    private val dogsImages = MutableLiveData<List<DogImage>>()

    fun getDogsImages(): LiveData<List<DogImage>> = dogsImages

    fun init() {
        viewModelScope.launch {
            val response = dogImageRepository.getRandomImages(50)
            dogsImages.postValue(response)
        }
    }
}