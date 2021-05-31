package com.onix.internship.infinity.infinity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.PopUpToBuilder
import com.onix.internship.infinity.SingleLiveEvent

class InfinityViewModel(countFragment: Int) : ViewModel() {

    private val _navigation = SingleLiveEvent<NavDirections>()
    val navigation: LiveData<NavDirections> = _navigation

    private val _countCurrentFragment = MutableLiveData(countFragment)
    val countCurrentFragment: LiveData<Int> = _countCurrentFragment

    private fun getCount() = _countCurrentFragment.value!!

    fun nextFragment() {
        _navigation.value = InfinityFragmentDirections.actionInfinityFragmentSelf(getCount() + 1)
    }

    fun resetFragments() {
        _navigation.value = InfinityFragmentDirections.actionInfinityFragmentReset()
    }

    fun prevFragment(){
        if(getCount() > 0){
            _navigation.value = InfinityFragmentDirections.actionInfinityFragmentSelf(getCount(), true)
            return
        }
        _navigation.value = InfinityFragmentDirections.actionInfinityFragmentToExitDialog()
    }
}