package jakmot.com.doggoparadise.gallery

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import jakmot.com.doggoparadise.databinding.GalleryItemBinding
import jakmot.com.doggoparadise.domain.Dog

class GalleryItemViewHolder(
    private val binding: GalleryItemBinding,
    private val onItemSelected: (Dog) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dog: Dog) {
        with(binding) {
            title.text = dog.name
            subtitle.text = dog.shortDescription
            Glide.with(root.context)
                .load(dog.imageUrl)
                .into(image)
            container.setOnClickListener { onItemSelected(dog) }
        }
    }
}
