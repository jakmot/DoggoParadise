package jakmot.com.doggoparadise.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jakmot.com.doggoparadise.api.DogCeoService
import kotlinx.coroutines.launch

class GalleryViewModel(
    private val dogCeoService: DogCeoService,
) : ViewModel() {

    private val textToDisplay = MutableLiveData<String>().apply {
        value = "Doggo Paradise"
    }

    fun getTextToDisplay(): LiveData<String> = textToDisplay

    fun init() {
        viewModelScope.launch {
            val response = dogCeoService.getRandomImage(50)
            println(response)
        }
    }
}