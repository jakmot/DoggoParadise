package jakmot.com.doggoparadise.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import jakmot.com.doggoparadise.api.DogImage
import jakmot.com.doggoparadise.databinding.DogDetailsFragmentBinding


class DogDetailsFragment : Fragment() {

    private var binding: DogDetailsFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DogDetailsFragmentBinding.inflate(layoutInflater, container, false)
            .also {
                binding = it
            }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = requireBinding()
        (arguments?.get(DOG_DATA) as? DogImage)?.let { dogImage ->
            Glide.with(this)
                .load(dogImage.url)
                .into(binding.image)
        }
    }

    private fun requireBinding(): DogDetailsFragmentBinding =
        binding
            ?: throw IllegalStateException("Accessing binding outside of Fragment lifecycle: DogDetailsFragment")

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val DOG_DATA = "DOG_DATA"
        fun createBundle(dogImage: DogImage): Bundle = bundleOf(
            DOG_DATA to dogImage
        )
    }
}