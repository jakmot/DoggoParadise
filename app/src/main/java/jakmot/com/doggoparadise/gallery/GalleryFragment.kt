package jakmot.com.doggoparadise.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import jakmot.com.doggoparadise.R
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
        viewModel.getDogsImages().observe(viewLifecycleOwner) { dogsImages ->
            requireBinding().message.text = dogsImages.joinToString()
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

    private fun requireBinding(): GalleryFragmentBinding =
        binding
            ?: throw IllegalStateException("Accessing binding outside of Fragment lifecycle: GalleryFragment")

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        fun newInstance() = GalleryFragment()
    }
}