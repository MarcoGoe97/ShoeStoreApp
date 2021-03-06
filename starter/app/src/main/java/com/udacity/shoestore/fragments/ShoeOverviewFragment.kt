package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeOverviewBinding
import com.udacity.shoestore.viewmodels.ShoeOverviewViewModel
import com.udacity.shoestore.viewmodels.ShoeViewModel

class ShoeOverviewFragment : Fragment() {

    private lateinit var viewModel : ShoeOverviewViewModel
    private val shoeViewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding : FragmentShoeOverviewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_overview, container, false)

        viewModel = ViewModelProvider(this).get(ShoeOverviewViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.addShoe.observe(viewLifecycleOwner) { navigate ->
            if(navigate){
                addShoe()
                viewModel.addShoeFinished()
            }
        }

        shoeViewModel.shoeList.observe(viewLifecycleOwner) { shoes ->
            shoes.forEach { shoe ->
                val view = inflater.inflate(R.layout.list_item_shoe, null)
                view.findViewById<TextView>(R.id.tvName).text = getString(R.string.item_name, shoe.name)
                view.findViewById<TextView>(R.id.tvCompany).text = getString(R.string.item_company, shoe.company)
                view.findViewById<TextView>(R.id.tvSize).text = getString(R.string.item_size, shoe.size.toString())
                view.findViewById<TextView>(R.id.tvDescription).text = getString(R.string.item_description, shoe.description)
                binding.mainLayout.addView(view)
            }
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun addShoe(){
        findNavController().navigate(ShoeOverviewFragmentDirections.actionShoeOverviewFragmentToShoeDetailsFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}