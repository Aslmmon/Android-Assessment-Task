package com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.repository

import com.example.tap_payment_task.features.tap_payment_bottomSheet.data.model.PaymentSourcesResponse


interface TapPaymentRepository {
     fun getPaymentTypes(): MutableList<PaymentSourcesResponse>

}