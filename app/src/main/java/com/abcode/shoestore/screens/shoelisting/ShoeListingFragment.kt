package com.abcode.shoestore.screens.shoelisting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.abcode.shoestore.R
import com.abcode.shoestore.databinding.FragmentShoeListingBinding

class ShoeListingFragment : Fragment() {

    private lateinit var viewModel : ShoeListingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding : FragmentShoeListingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)

        viewModel = ViewModelProvider(this).get(ShoeListingViewModel::class.java)

        return binding.root
    }
}