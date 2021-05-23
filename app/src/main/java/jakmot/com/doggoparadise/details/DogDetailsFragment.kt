package jakmot.com.doggoparadise.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import jakmot.com.doggoparadise.databinding.DogDetailsFragmentBinding


class DogDetailsFragment : Fragment() {

    private var binding: DogDetailsFragmentBinding? = null

    private val args: DogDetailsFragmentArgs by navArgs()


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
        Glide.with(this)
            .load(args.dogImage.url)
            .into(binding.image)
    }

    private fun requireBinding(): DogDetailsFragmentBinding =
        binding
            ?: throw IllegalStateException("Accessing binding outside of Fragment lifecycle: DogDetailsFragment")

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}