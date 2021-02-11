package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.viewmodels.ShoeDetailsViewModel
import com.udacity.shoestore.viewmodels.ShoeViewModel

class ShoeDetailsFragment : Fragment(){

    private lateinit var viewModel : ShoeDetailsViewModel
    val shoeViewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding : FragmentShoeDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        viewModel = ViewModelProvider(this).get(ShoeDetailsViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.save.observe(viewLifecycleOwner) { navigate ->
            if(navigate){
                save()
                viewModel.saveFinished()
            }
        }

        viewModel.cancel.observe(viewLifecycleOwner) { navigate ->
            if(navigate){
                cancel()
                viewModel.cancelFinished()
            }
        }

        return binding.root
    }

    private fun cancel() {
        findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeOverviewFragment())
    }

    private fun save() {
        findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeOverviewFragment())
    }
}