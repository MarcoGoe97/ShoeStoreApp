package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel :ViewModel() {

    private val _login = MutableLiveData<Boolean>()
    val login : LiveData<Boolean>
        get() = _login

    fun onLogin() {
        _login.value = true
    }

    fun loginDone() {
        _login.value = false
    }
}