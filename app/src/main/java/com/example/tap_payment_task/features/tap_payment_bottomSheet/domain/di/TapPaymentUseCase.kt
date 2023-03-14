package com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.di

import com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.repository.TapPaymentRepository
import com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.usecase.GetPaymentTypesUseCase
import com.example.tap_payment_task.features.tap_payment_bottomSheet.domain.usecase.GetPaymentTypesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class TapPaymentUseCase {


    @Provides
    fun bindGetPaymentTypes(homeRepository: TapPaymentRepository): GetPaymentTypesUseCase {
        return GetPaymentTypesUseCaseImpl(homeRepository)
    }


}
