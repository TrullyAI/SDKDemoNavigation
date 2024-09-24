package ai.trully.sdk.testnavigationimplementation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.trully.sdk.testnavigationimplementation.R
import ai.trully.sdk.testnavigationimplementation.databinding.FragmentEndBinding

class EndFragment : Fragment() {

    private lateinit var binding: FragmentEndBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEndBinding.inflate(inflater, container, false)
        return binding.root
    }
}