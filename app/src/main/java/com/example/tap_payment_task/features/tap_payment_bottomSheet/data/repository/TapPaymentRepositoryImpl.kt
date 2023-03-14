package com.example.tap_payment_task.features.tap_payment_bottomSheet.data.repository
import com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.repository.TapPaymentRepository
import com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation.adapter.PaymentTypeData
import javax.inject.Inject

class TapPaymentRepositoryImpl @Inject constructor() :
    TapPaymentRepository {
    override fun getPaymentTypes() = mutableListOf<PaymentTypeData>(
        PaymentTypeData(
            1,
        ),
        PaymentTypeData(
            2,
        ),
        PaymentTypeData(
            3,
        ),
        PaymentTypeData(
            4,
            ),
    )

}