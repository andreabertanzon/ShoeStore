package com.abcode.shoestore.screens.shoelisting

import android.graphics.Color
import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.abcode.shoestore.R
import com.abcode.shoestore.databinding.FragmentShoeListingBinding
import com.abcode.shoestore.models.Shoes

class ShoeListingFragment : Fragment() {

    private val viewModel : ShoeListingViewModel by activityViewModels() //viewModel tied to the activity.
    private lateinit var binding : FragmentShoeListingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)

        viewModel.shoesList.observe(viewLifecycleOwner,{
            Log.i("VM", "${viewModel.shoesList.value?.count()}")
            viewModel.shoesList.value?.let { el -> createShoes(el) }
        })

        binding.addButton.setOnClickListener{
            val action = ShoeListingFragmentDirections.actionShoeListingFragmentToDetailsFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root
    }
    private fun createShoes(shoes: List<Shoes>) {
        context?.let { context ->
            val shoesContainer = binding.shoesContainer
            shoes.forEach { pairOfshoes ->
//                val shoeLayout = ShoeLayout(context)
//                shoesLayout.loadShoe(shoe)
//                shoesContainer.addView(shoesLayout)
                val shoesLayout = TextView(context)
                shoesLayout.text = pairOfshoes.name
//                shoesLayout.setTextColor(Color.BLACK)
                shoesLayout.layoutParams= LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                shoesContainer.addView(shoesLayout)
            }
        }
    }
}


