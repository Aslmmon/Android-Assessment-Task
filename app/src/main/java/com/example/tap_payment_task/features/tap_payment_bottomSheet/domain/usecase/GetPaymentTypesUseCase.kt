package com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.usecase

import com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.repository.TapPaymentRepository
import com.example.tap_payment_task.features.tap_payment_bottomSheet.presentation.adapter.PaymentTypeData
import javax.inject.Inject

interface GetPaymentTypesUseCase {
     fun getPaymentTypesUseCase(): MutableList<PaymentTypeData>
}

class GetPaymentTypesUseCaseImpl @Inject constructor(var tapPaymentRepository: TapPaymentRepository) :
    GetPaymentTypesUseCase {
    override  fun getPaymentTypesUseCase() = tapPaymentRepository.getPaymentTypes()


}