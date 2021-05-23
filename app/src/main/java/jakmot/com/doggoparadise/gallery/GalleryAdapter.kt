package jakmot.com.doggoparadise.gallery

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jakmot.com.doggoparadise.api.DogImage
import jakmot.com.doggoparadise.common.layoutInflater
import jakmot.com.doggoparadise.databinding.GalleryItemBinding

class GalleryAdapter(
    private val onDogSelected: (DogImage) -> Unit,
) : RecyclerView.Adapter<GalleryItemViewHolder>() {

    var dogList: List<DogImage> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryItemViewHolder {
        val binding = GalleryItemBinding.inflate(parent.layoutInflater(), parent, false)
        return GalleryItemViewHolder(binding, onDogSelected)
    }

    override fun onBindViewHolder(holder: GalleryItemViewHolder, position: Int) {
        holder.bind(dogList[position])
    }

    override fun getItemCount(): Int = dogList.size
}