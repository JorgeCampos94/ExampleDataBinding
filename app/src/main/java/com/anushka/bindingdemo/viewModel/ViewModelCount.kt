package com.anushka.bindingdemo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelCount(startingTotal : Int) : ViewModel(){
    private var totalSum = MutableLiveData<Int>()

    val totalData : LiveData<Int>
        get() = totalSum

    init {
        totalSum.value = startingTotal
    }

    fun getUpdatedResult(count : Int){
        totalSum.value = (totalSum.value)?.plus(count)
    }
}