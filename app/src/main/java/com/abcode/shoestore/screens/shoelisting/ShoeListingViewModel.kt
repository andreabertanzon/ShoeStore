package com.abcode.shoestore.screens.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abcode.shoestore.models.Shoes

class ShoeListingViewModel : ViewModel() {

    private val _shoesList = MutableLiveData<MutableList<Shoes>>()
    val shoesList: LiveData<MutableList<Shoes>>
        get() = _shoesList

    init {
        _shoesList.value = mutableListOf()
    }
}