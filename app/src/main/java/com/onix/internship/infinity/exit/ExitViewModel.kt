package com.onix.internship.infinity.exit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onix.internship.infinity.SingleLiveEvent

class ExitViewModel() : ViewModel() {

    private val _dialogEvent = SingleLiveEvent<Boolean>()
    val dialogEvent: LiveData<Boolean> = _dialogEvent


    fun onClickButtonYes() {
        _dialogEvent.value = true
    }

    fun onClickButtonNo() {
        _dialogEvent.value = false
    }
}