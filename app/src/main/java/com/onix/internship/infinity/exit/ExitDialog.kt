package com.onix.internship.infinity.exit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.onix.internship.infinity.databinding.DialogExitBinding

class ExitDialog : DialogFragment() {


    private lateinit var binding: DialogExitBinding

    private val viewModel: ExitViewModel by viewModels { ExitViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogExitBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.dialogEvent.observe(viewLifecycleOwner, {
            if (it == true) {
                requireActivity().finish()
            } else if (it == false) {
                dismiss()
            }
        })
    }
}