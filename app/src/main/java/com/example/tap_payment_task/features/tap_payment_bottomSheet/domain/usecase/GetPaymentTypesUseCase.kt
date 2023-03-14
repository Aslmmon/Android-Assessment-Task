package com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.usecase

import com.example.tap_payment_task.features.tap_payment_bottomSheet.data.model.PaymentSourcesResponse
import com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.repository.TapPaymentRepository
import javax.inject.Inject

interface GetPaymentTypesUseCase {
     fun getPaymentTypesUseCase(): MutableList<PaymentSourcesResponse>
}

class GetPaymentTypesUseCaseImpl @Inject constructor(var tapPaymentRepository: TapPaymentRepository) :
    GetPaymentTypesUseCase {
    override  fun getPaymentTypesUseCase() = tapPaymentRepository.getPaymentTypes()


}