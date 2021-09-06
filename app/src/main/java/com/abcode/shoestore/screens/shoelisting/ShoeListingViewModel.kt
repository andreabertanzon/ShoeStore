package com.abcode.shoestore.screens.shoelisting

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abcode.shoestore.models.Shoes
import com.abcode.shoestore.BR

class ShoeListingViewModel : ViewModel(), Observable {

    private val propertyChangeRegistry = PropertyChangeRegistry()
    private val _shoesList = MutableLiveData<MutableList<Shoes>>()

    val shoesList: LiveData<MutableList<Shoes>>
        get() = _shoesList

    @Bindable
    var shoes = Shoes()
        set(value) {
            if(value != field) {
                field = value
                propertyChangeRegistry.notifyChange(this, BR.shoes)
            }
        }

    init {
        _shoesList.value = mutableListOf()
    }

    fun addShoes(newShoes: Shoes){
        _shoesList.value?.add(Shoes(
            newShoes.name,
            newShoes.company,
            newShoes.size,
            newShoes.description
        ))
        shoes = Shoes()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    fun cancelShoesAdd() {
        shoes = Shoes()
    }
}