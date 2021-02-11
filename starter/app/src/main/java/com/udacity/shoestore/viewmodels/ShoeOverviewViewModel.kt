package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeOverviewViewModel : ViewModel() {

    private val _addShoe = MutableLiveData<Boolean>()
    val addShoe : LiveData<Boolean>
        get() = _addShoe

    fun addShoe(){
        _addShoe.value = true
    }

    fun addShoeFinished(){
        _addShoe.value = false
    }
}