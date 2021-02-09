package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel : ViewModel() {

    private val _start = MutableLiveData<Boolean>()
    val start : LiveData<Boolean>
        get() = _start

    fun onStart() {
        _start.value = true
    }

    fun startDone() {
        _start.value = false
    }
}