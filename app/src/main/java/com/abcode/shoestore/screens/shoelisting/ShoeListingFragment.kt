package com.abcode.shoestore.screens.shoelisting

import android.graphics.Color
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.abcode.shoestore.R
import com.abcode.shoestore.databinding.FragmentShoeListingBinding
import com.abcode.shoestore.models.Shoes
import com.abcode.shoestore.screens.ShoesCard

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
            viewModel.shoesList.value?.let { el -> createShoes(el) }
        })

        setHasOptionsMenu(true)

        binding.addButton.setOnClickListener{
            val action = ShoeListingFragmentDirections.actionShoeListingFragmentToDetailsFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root
    }

// built from: https://stackoverflow.com/questions/2395769/how-to-programmatically-add-views-to-views
    private fun createShoes(shoes: List<Shoes>) {
        context?.let { context ->
            val shoesContainer = binding.shoesContainer
            shoes.forEach { pairOfshoes ->
                val shoesCard = ShoesCard(context)
                if (shoesCard.parent != null){
                    val parentView:ViewGroup = shoesCard.parent as ViewGroup
                    parentView.removeView(shoesCard)
                }
                shoesCard.setShoesInCard(pairOfshoes)
                shoesCard.layoutParams= LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                shoesContainer.addView(shoesCard)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController()) || super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater)
        menuInflater.inflate(R.menu.options_menu, menu)
    }
}


