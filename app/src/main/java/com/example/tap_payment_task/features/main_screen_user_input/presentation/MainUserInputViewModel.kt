package com.example.tap_payment_task.features.main_screen_user_input.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainUserInputViewModel @Inject constructor() : ViewModel() {

    private val _amountTyped = MutableLiveData<String>()
    val amountTyped: LiveData<String> = _amountTyped


    fun setAmountWritten(amount: String) {
        _amountTyped.value = amount
    }

    init {
        setAmountWritten("")
    }
}