package com.example.tap_payment_task.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * SharedViewModel here is used to share data between fragments
 * like from mainScreenUserInput to >> TapPaymentBottomSheet
 */
class SharedViewModel : ViewModel() {

    private val _paymentAmount = MutableLiveData<Pair<String,String>>()
    val paymentAmount: LiveData<Pair<String,String>> = _paymentAmount


    fun setPaymentAmount(payment: String,currency: String) {
        _paymentAmount.value = Pair(payment,currency)
    }

}