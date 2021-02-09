package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _toInstructions = MutableLiveData<Boolean>()
    val toInstructions : LiveData<Boolean>
        get() = _toInstructions

    fun onToInstructions() {
        _toInstructions.value = true
    }

    fun toInstructionsDone() {
        _toInstructions.value = false
    }
}