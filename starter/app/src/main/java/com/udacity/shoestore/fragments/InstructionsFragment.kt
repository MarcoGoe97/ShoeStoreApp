package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.viewmodels.InstructionsViewModel

class InstructionsFragment : Fragment() {

    private lateinit var viewModel : InstructionsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding : FragmentInstructionsBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_instructions, container, false)

        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)
        binding.welcomeViewModel = viewModel

        viewModel.start.observe(viewLifecycleOwner){ navigate ->
            if(navigate){
                toMainScreen()
                viewModel.startDone()
            }
        }

        return binding.root
    }

    private fun toMainScreen() {

    }
}