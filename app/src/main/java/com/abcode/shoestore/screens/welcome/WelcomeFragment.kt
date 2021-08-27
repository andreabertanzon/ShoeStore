package com.abcode.shoestore.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.abcode.shoestore.R
import com.abcode.shoestore.databinding.FragmentWelcomeBinding
import com.abcode.shoestore.screens.login.LoginFragmentDirections

class WelcomeFragment : Fragment() {

    private lateinit var viewModel: WelcomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentWelcomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)

        binding.nextButton.setOnClickListener{
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root
    }
}