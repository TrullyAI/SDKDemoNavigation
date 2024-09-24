package ai.trully.sdk.testnavigationimplementation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.trully.sdk.testnavigationimplementation.R
import ai.trully.sdk.testnavigationimplementation.databinding.FragmentStartBinding
import androidx.navigation.fragment.findNavController

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoToValidate.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_trullySdkFragment)
        }
    }
}