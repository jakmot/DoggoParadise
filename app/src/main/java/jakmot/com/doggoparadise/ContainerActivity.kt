package jakmot.com.doggoparadise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jakmot.com.doggoparadise.gallery.GalleryFragment

class ContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_activity)
    }
}