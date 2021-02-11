package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailsViewModel : ViewModel() {

    private val _save = MutableLiveData<Boolean>()
    val save : LiveData<Boolean>
        get() = _save

    private val _cancel = MutableLiveData<Boolean>()
    val cancel : LiveData<Boolean>
        get() = _cancel

    fun save(){
        _save.value = true
    }

    fun saveFinished(){
        _save.value = false
    }

    fun cancel(){
        _cancel.value = true
    }

    fun cancelFinished(){
        _cancel.value = false
    }
}