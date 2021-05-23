package jakmot.com.doggoparadise.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import jakmot.com.doggoparadise.R
import jakmot.com.doggoparadise.domain.Dog
import jakmot.com.doggoparadise.common.observeEvent
import jakmot.com.doggoparadise.databinding.GalleryFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GalleryFragment : Fragment() {
    private val viewModel: GalleryViewModel by viewModel()

    private var binding: GalleryFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return GalleryFragmentBinding.inflate(layoutInflater, container, false)
            .also {
                binding = it
            }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = requireBinding()

        val galleryAdapter = GalleryAdapter(::navigateToDogDetails)
        binding.recyclerView.apply {
            adapter = galleryAdapter
            layoutManager = GridLayoutManager(this@GalleryFragment.requireContext(), 2)

        }
        viewModel.getDogsImages().observe(viewLifecycleOwner) { dogsImages ->
            galleryAdapter.dogList = dogsImages
            galleryAdapter.notifyDataSetChanged()
        }
        viewModel.shouldShowError().observeEvent(viewLifecycleOwner) { shouldShowError ->
            if (shouldShowError) {
                Snackbar.make(
                    requireBinding().root,
                    getString(R.string.error_message),
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
        viewModel.init()
    }

    private fun navigateToDogDetails(dog: Dog) {
        val action =
            GalleryFragmentDirections.actionGalleryFragmentToDogDetailsFragment(dog)
        findNavController().navigate(action)
    }

    private fun requireBinding(): GalleryFragmentBinding =
        binding
            ?: throw IllegalStateException("Accessing binding outside of Fragment lifecycle: GalleryFragment")

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}