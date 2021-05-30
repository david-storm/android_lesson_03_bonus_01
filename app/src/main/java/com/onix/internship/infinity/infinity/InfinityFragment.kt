package com.onix.internship.infinity.infinity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.onix.internship.infinity.databinding.FragmentInfinityBinding


class InfinityFragment : Fragment() {

    private lateinit var binding: FragmentInfinityBinding

    private val args: InfinityFragmentArgs by navArgs()
    private val viewModel: InfinityViewModel by viewModels { InfinityViewModelFactory(args.count) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInfinityBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        viewModel.navigation.observe(viewLifecycleOwner, ::navigate)
        viewModel.backNavigation.observe(viewLifecycleOwner, ::navigateBack)

    }


    private fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }

    private fun navigateBack(boolean: Boolean) {
        findNavController().popBackStack()
    }
}