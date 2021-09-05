package com.abcode.shoestore.screens.shoedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        viewModel = ViewModelProvider(requireActivity()).get(ShoeListingViewModel::class.java)

        binding.saveBtn.setOnClickListener {
            onSavePressed()
        }

        return binding.root
    }

    private fun onSavePressed() {
        val newShoes = Shoes(
            binding.nameText.text.toString(),
            binding.companyText.text.toString(),
            binding.sizeText.text.toString().toDouble(),
            binding.descriptionText.text.toString()
        )
        viewModel.addShoes(newShoes)
        val action = DetailsFragmentDirections.actionDetailsFragmentToShoeListingFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
}