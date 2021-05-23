package jakmot.com.doggoparadise.gallery

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import jakmot.com.doggoparadise.domain.Dog
import jakmot.com.doggoparadise.databinding.GalleryItemBinding

class GalleryItemViewHolder(
    private val binding: GalleryItemBinding,
    private val onItemSelected: (Dog) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dog: Dog) {
        Glide.with(binding.root.context)
            .load(dog.url)
            .into(binding.image)
        binding.container.setOnClickListener { onItemSelected(dog) }
    }
}
