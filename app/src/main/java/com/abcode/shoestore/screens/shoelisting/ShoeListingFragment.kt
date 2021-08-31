package com.abcode.shoestore.screens.shoelisting

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
import com.abcode.shoestore.databinding.FragmentShoeListingBinding

class ShoeListingFragment : Fragment() {

    private val viewModel : ShoeListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding : FragmentShoeListingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)

        //viewModel = ViewModelProvider(this).get(ShoeListingViewModel::class.java)

        binding.addButton.setOnClickListener{
            val action = ShoeListingFragmentDirections.actionShoeListingFragmentToDetailsFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root
    }

    /*
    * from stackoverflow discussion:
    * private fun createShoes(shoes: List<Shoe>) {
        context?.let { context ->
            val shoeContainer = binding.list
            shoes.forEach { shoe ->
                val shoeLayout = ShoeLayout(context)
                shoeLayout.loadShoe(shoe)
                shoeContainer.addView(shoeLayout)
            }
        }
    * */
}