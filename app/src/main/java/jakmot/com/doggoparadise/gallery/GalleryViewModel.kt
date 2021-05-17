package jakmot.com.doggoparadise.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val textToDisplay = MutableLiveData<String>().apply {
        value = "Doggo Paradise"
    }

    fun getTextToDisplay(): LiveData<String> = textToDisplay
}