package ai.trully.sdk.testnavigationimplementation.fragments

import ai.trully.sdk.TrullySdk
import ai.trully.sdk.configurations.TrullyConfig
import ai.trully.sdk.configurations.TrullyStyles
import ai.trully.sdk.models.Environment
import ai.trully.sdk.models.ErrorData
import ai.trully.sdk.models.Texts
import ai.trully.sdk.models.TrackDetail
import ai.trully.sdk.models.TrackStep
import ai.trully.sdk.models.TrullyResponse
import ai.trully.sdk.protocols.listeners.TrullyListeners
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ai.trully.sdk.testnavigationimplementation.R
import ai.trully.sdk.testnavigationimplementation.databinding.FragmentTrullySdkBinding
import android.util.Log
import androidx.navigation.fragment.findNavController

class TrullySdkFragment : Fragment(), TrullyListeners {

    private lateinit var binding: FragmentTrullySdkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrullySdkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onTap()
        initialize()
    }

    private fun onTap() {
        TrullySdk.start(requireContext(), this)
    }

    private fun initialize() {
        val styles = TrullyStyles()
        styles.uiTexts.docType = Texts.PASSPORT

        styles.primaryColor = com.regula.common.R.color.red
        styles.disabledColor = com.regula.common.R.color.dark_green
        styles.backgroundColor = androidx.appcompat.R.color.button_material_dark

        styles.logo = ai.trully.sdk.R.drawable.logo
        styles.IDIcon = ai.trully.sdk.R.drawable.selfie
        styles.selfieIcon = ai.trully.sdk.R.drawable.ine
        styles.IdImage = ai.trully.sdk.R.drawable.ine
        styles.permission = ai.trully.sdk.R.drawable.ine
        styles.light = ai.trully.sdk.R.drawable.ine
        styles.cross = ai.trully.sdk.R.drawable.ine
        styles.showId = ai.trully.sdk.R.drawable.ine
        styles.check = ai.trully.sdk.R.drawable.ine
        styles.faceTimeout = ai.trully.sdk.R.drawable.ine
        styles.noLocation = ai.trully.sdk.R.drawable.ine
        styles.noCamera = ai.trully.sdk.R.drawable.ine
        styles.errorIcon = ai.trully.sdk.R.drawable.ine


        val config = TrullyConfig(
            Environment.RELEASE,
            "test-sdk-kotlin",
            showIdView = true
        )

        TrullySdk.init("put your key here", config)
    }

    override fun onError(errorData: ErrorData) {
        Log.d("onError", errorData.toString())
    }

    override fun onResult(response: TrullyResponse) {
        findNavController().navigate(R.id.action_trullySdkFragment_to_endFragment)
    }

    override fun onTrack(trackStep: TrackStep) {
        Log.d("onTrack", trackStep.toString())
    }

    override fun onTrackDetail(trackDetail: TrackDetail) {
        Log.d("onTrackDetail", trackDetail.toString())
    }
}