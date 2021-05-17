package jakmot.com.doggoparadise.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val textToDisplay = MutableLiveData<String>().apply {
        value = "Doggo Paradise"
    }

    fun getTextToDisplay(): LiveData<String> = textToDisplay
}