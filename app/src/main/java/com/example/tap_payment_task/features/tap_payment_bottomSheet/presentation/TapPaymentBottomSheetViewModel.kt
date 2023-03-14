package com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation

import androidx.lifecycle.ViewModel
import com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.usecase.GetPaymentTypesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TapPaymentBottomSheetViewModel  @Inject constructor(
    private val getPaymentTypesUseCase: GetPaymentTypesUseCase
): ViewModel() {

    fun getPaymentData() = getPaymentTypesUseCase.getPaymentTypesUseCase()
}