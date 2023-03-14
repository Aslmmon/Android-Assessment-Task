package com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.repository

import com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation.adapter.PaymentTypeData

interface TapPaymentRepository {
     fun getPaymentTypes(): MutableList<PaymentTypeData>

}