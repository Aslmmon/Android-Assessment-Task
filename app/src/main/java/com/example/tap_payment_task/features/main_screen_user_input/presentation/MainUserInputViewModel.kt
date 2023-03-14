package com.example.tap_payment_task.features.main_screen_user_input.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel related to first screen of MainUserInput
 * with a simple function just to update each character of amount written to be in text
 * of AppButton
 */
@HiltViewModel
class MainUserInputViewModel @Inject constructor() : ViewModel() {

    private val _amountToBePaid = MutableLiveData<String>()
    val amountToBePaid: LiveData<String> = _amountToBePaid


    fun setAmountToBePaid(amount: String) {
        _amountToBePaid.value = amount
    }

    init {
        setAmountToBePaid("")
    }
}