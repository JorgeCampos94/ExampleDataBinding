package com.anushka.bindingdemo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelCountFactory(private val  startingValue : Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelCount::class.java)){
            return ViewModelCount(startingValue) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}