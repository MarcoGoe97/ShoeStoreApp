package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.viewmodels.WelcomeViewModel

class WelcomeFragment: Fragment() {

    private lateinit var viewModel : WelcomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding : FragmentWelcomeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_welcome, container, false)

        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding.welcomeViewModel = viewModel

        viewModel.toInstructions.observe(viewLifecycleOwner) { navigate ->
            if(navigate){
                toInstructions()
                viewModel.toInstructionsDone()
            }
        }

        return binding.root
    }

    private fun toInstructions() {
        findNavController(this).navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
    }
}