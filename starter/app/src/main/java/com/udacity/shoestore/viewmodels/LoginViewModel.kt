package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel :ViewModel() {
    private val _navigate = MutableLiveData<Boolean>()
    val navigate : LiveData<Boolean>
        get() = _navigate

    fun onNavigate() {
        _navigate.value = true
    }

    fun navigateDone() {
        _navigate.value = false
    }
}