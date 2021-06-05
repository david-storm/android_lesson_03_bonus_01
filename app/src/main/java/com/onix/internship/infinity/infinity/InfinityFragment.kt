package com.onix.internship.infinity.infinity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.onix.internship.infinity.databinding.FragmentInfinityBinding


class InfinityFragment : Fragment() {

    private lateinit var binding: FragmentInfinityBinding

    private val args: Bundle? = arguments
    private val count :Int = (args?.get("count") ?: 0 ) as Int
    private val viewModel: InfinityViewModel by viewModels { InfinityViewModelFactory(count) }

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
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigate(InfinityFragmentDirections.actionInfinityFragmentToExitDialog())
            }
        }
        if (viewModel.countCurrentFragment.value == 0) {
            requireActivity().onBackPressedDispatcher.addCallback(this, callback)
        }
    }


    private fun navigate(direction: NavDirections) {

        if(direction == InfinityFragmentDirections.actionInfinityFragmentPop()){
            requireActivity().onBackPressed()
            return
        }
        findNavController().navigate(direction)
    }
}