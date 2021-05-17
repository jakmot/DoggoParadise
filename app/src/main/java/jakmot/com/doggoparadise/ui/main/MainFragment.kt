package jakmot.com.doggoparadise.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import jakmot.com.doggoparadise.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val message = view.findViewById<TextView>(R.id.message)

        viewModel.getTextToDisplay().observe(viewLifecycleOwner) {
            message.text = it
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}