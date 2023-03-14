package com.example.tap_payment_task.features.tap_payment_bottomSheet.data.repository

import android.net.Uri
import com.example.tap_payment_task.R
import com.example.tap_payment_task.features.tap_payment_bottomSheet.data.model.PaymentSourcesResponse
import com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.repository.TapPaymentRepository
import javax.inject.Inject

const val projectPath = "android.resource://com.example.tap_payment_task/"

class TapPaymentRepositoryImpl @Inject constructor() :
    TapPaymentRepository {
    override fun getPaymentTypes() = mutableListOf<PaymentSourcesResponse>(
        PaymentSourcesResponse(
            id = 1,
            image = Uri.parse(projectPath + R.drawable.google_pay)
        ),
        PaymentSourcesResponse(
            id = 2,
            image = Uri.parse(projectPath + R.drawable.apple_pay)
        ),
        PaymentSourcesResponse(
            id = 3,
            isHaveCardData = true,
            cardNumber = "**** 4242"
        ),
        PaymentSourcesResponse(
            id = 4,
            isHaveCardData = true,
            cardNumber = "**** 1212"
        ),
        PaymentSourcesResponse(
            5,
            isHaveCardData = true,
            cardNumber = "**** 3432"

        )
    )

}