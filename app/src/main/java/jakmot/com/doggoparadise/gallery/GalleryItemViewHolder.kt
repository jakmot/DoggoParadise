package jakmot.com.doggoparadise.gallery

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import jakmot.com.doggoparadise.api.DogImage
import jakmot.com.doggoparadise.databinding.GalleryItemBinding

class GalleryItemViewHolder(
    private val binding: GalleryItemBinding,
    private val onItemSelected: (DogImage) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dogImage: DogImage) {
        Glide.with(binding.root.context)
            .load(dogImage.url)
            .into(binding.image)
        binding.container.setOnClickListener { onItemSelected(dogImage) }
    }
}
