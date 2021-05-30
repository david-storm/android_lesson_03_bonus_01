package com.onix.internship.infinity.infinity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InfinityViewModelFactory (
    private val count: Int
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InfinityViewModel::class.java)) {
            return InfinityViewModel(count) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}