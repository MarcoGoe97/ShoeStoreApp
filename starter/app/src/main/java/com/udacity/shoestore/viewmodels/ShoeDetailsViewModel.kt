package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailsViewModel : ViewModel() {

    private val _save = MutableLiveData<Boolean>()
    val save : LiveData<Boolean>
        get() = _save

    private val _cancel = MutableLiveData<Boolean>()
    val cancel : LiveData<Boolean>
        get() = _cancel

    private val _validateData = MutableLiveData(false)
    val validateData : LiveData<Boolean>
        get() = _validateData

    val name = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val description = MutableLiveData<String>()

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

    fun getShoe() : Shoe {
       return Shoe(name.value!!, size.value!!.toDoubleOrNull()?:0.0, company.value!!, description.value!!)
    }

    fun onTextChanged() {
        _validateData.value = checkData()
    }

    private fun checkData() : Boolean {
        return !name.value.isNullOrEmpty() && !company.value.isNullOrEmpty() && !size.value.isNullOrEmpty() && !description.value.isNullOrEmpty()
    }
}