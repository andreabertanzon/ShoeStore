package com.abcode.shoestore.screens.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.abcode.shoestore.R
import com.abcode.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentInstructionsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)

        binding.confirmButton.setOnClickListener{
            val action = InstructionsFragmentDirections.actionInstructionsFragmentToShoeListingFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root
    }
}