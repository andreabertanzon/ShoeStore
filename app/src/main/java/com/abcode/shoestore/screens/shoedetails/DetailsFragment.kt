package com.abcode.shoestore.screens.shoedetails

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.abcode.shoestore.R
import com.abcode.shoestore.databinding.FragmentDetailsBinding
import com.abcode.shoestore.databinding.FragmentShoeListingBinding
import com.abcode.shoestore.models.Shoes
import com.abcode.shoestore.screens.shoelisting.ShoeListingFragmentDirections
import com.abcode.shoestore.screens.shoelisting.ShoeListingViewModel


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: ShoeListingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        //retrieving the activityViewModel
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListingViewModel::class.java)

        // initialize the shoes variable into a new Shoes
        binding.shoes = Shoes()
        binding.shoesListViewModel = viewModel
        binding.saveBtn.setOnClickListener {
            onSavePressed()
        }

        binding.cancelBtn.setOnClickListener {
            onCancelPressed()
        }

        return binding.root
    }

    private fun onCancelPressed() {
        viewModel.cancelShoesAdd()
        val action = DetailsFragmentDirections.actionDetailsFragmentToShoeListingFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }

    private fun onSavePressed() {
        viewModel.addShoes(viewModel.shoes)
        val action = DetailsFragmentDirections.actionDetailsFragmentToShoeListingFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
}