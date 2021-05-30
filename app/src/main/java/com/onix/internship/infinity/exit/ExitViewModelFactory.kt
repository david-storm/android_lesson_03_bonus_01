package com.onix.internship.infinity.exit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ExitViewModelFactory(

) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExitViewModel::class.java)) {
            return ExitViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}